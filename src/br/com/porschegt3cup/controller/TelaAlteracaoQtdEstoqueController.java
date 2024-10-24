/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EntradaDAO;
import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.model.Entrada;
import br.com.porschegt3cup.model.Estoque;
import br.com.porschegt3cup.view.TelaAlteracaoQtdEstoque;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaAlteracaoQtdEstoqueController {
    
    Connection conexao = null;
    private TelaAlteracaoQtdEstoque telaAlteracaoQtdEstoque;
    Estoque estoque = null;

    public TelaAlteracaoQtdEstoqueController(TelaAlteracaoQtdEstoque telaAlteracaoQtdEstoque) {
        this.telaAlteracaoQtdEstoque = telaAlteracaoQtdEstoque;
    }

   
    
    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaAlteracaoQtdEstoque.getTxtLPesquisar().getText();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs;

        if (telaAlteracaoQtdEstoque.getrBtnPartNumber().isSelected()) {
            rs = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
        } else {
            rs = estoqueDao.procurarPecaEstoquePorDescricao(peca);
        }

        if (rs != null) {
            telaAlteracaoQtdEstoque.getTblEntradaPeca().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaAlteracaoQtdEstoque.getTblEntradaPeca());
        }

    }
    
     public void apagarCampos() {
        telaAlteracaoQtdEstoque.getTxtLPesquisar().setText(null);
        telaAlteracaoQtdEstoque.getTxtQuantidadeAtual().setText(null);
        
        DefaultTableModel tabela = (DefaultTableModel) telaAlteracaoQtdEstoque.getTblEntradaPeca().getModel();
        tabela.setRowCount(0);

    }
     
     public void coletaDadosPreencheVariaveis() {
        int linhaSelecionada = telaAlteracaoQtdEstoque.getTblEntradaPeca().getSelectedRow();
        int quantidadeAlterada = Integer.parseInt(telaAlteracaoQtdEstoque.getTxtQuantidadeAtual().getText());
        
        
        //int quantidadeEstoque = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 2).toString());
        int idEstoque = Integer.parseInt(telaAlteracaoQtdEstoque.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 6).toString());
        int idPeca = Integer.parseInt(telaAlteracaoQtdEstoque.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 7).toString());
        int idlocacao = Integer.parseInt(telaAlteracaoQtdEstoque.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 8).toString());
        //int quantidadeSomada = quantidadeEstoque + quantidadeEntrada;
        //System.out.println(quantidadeSomada);
        
        Estoque estoque = new Estoque(idEstoque, quantidadeAlterada);
        
        this.estoque = estoque;

    }
     
     public void alterarQtdEstoque() {
        conexao = ModuloConexao.conector();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        

        if (Utils.linhaSelecionadaContemDados(telaAlteracaoQtdEstoque.getTblEntradaPeca())) {
            coletaDadosPreencheVariaveis();
            estoqueDao.alterarQuantidadePecaEstoque(estoque.getId(), estoque.getQuantidade());
            JOptionPane.showMessageDialog(null, "Alteração de quantidade de peça realizado com sucesso");
            apagarCampos();

        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha da tabela com dados para registrar a entrada de uma peça ");

        }

    }
    
    
    
}
