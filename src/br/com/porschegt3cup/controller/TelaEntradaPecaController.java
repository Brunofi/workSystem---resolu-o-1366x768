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
import br.com.porschegt3cup.view.TelaEntradaPeca;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaEntradaPecaController {

    private TelaEntradaPeca telaEntradaPeca;
    Connection conexao = null;
    String colaboradorlancamento;
    Entrada entrada = null;
    Estoque estoque = null;
    

    public TelaEntradaPecaController(TelaEntradaPeca telaEntradaPeca) {
        this.telaEntradaPeca = telaEntradaPeca;
    }

    public void descobreColaborador() {
        colaboradorlancamento = TelaLoginController.colaborador;
        //System.out.println(colaboradorlancamento);

    }

    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaEntradaPeca.getTxtLPesquisar().getText();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs;

        if (telaEntradaPeca.getrBtnPartNumber().isSelected()) {
            rs = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
        } else {
            rs = estoqueDao.procurarPecaEstoquePorDescricao(peca);
        }

        if (rs != null) {
            telaEntradaPeca.getTblEntradaPeca().setModel(DbUtils.resultSetToTableModel(rs));
        }

    }

    public void coletaDadosPreencheVariaveis() {
        colaboradorlancamento = TelaLoginController.colaborador;
        int linhaSelecionada = telaEntradaPeca.getTblEntradaPeca().getSelectedRow();
        int quantidadeEntrada = Integer.parseInt(telaEntradaPeca.getTxtQuantidadeEntrada().getText());
        String motivo = telaEntradaPeca.getCbMotivo().getSelectedItem().toString();
        String observacao = telaEntradaPeca.getTxtObservacao().getText();
        int quantidadeEstoque = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 2).toString());
        int idEstoque = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 5).toString());
        int idPeca = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 6).toString());
        int idlocacao = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 7).toString());
        int quantidadeSomada = quantidadeEstoque + quantidadeEntrada;
        //System.out.println(quantidadeSomada);
        Entrada entrada = new Entrada(quantidadeEntrada, motivo, colaboradorlancamento, observacao, idPeca, idlocacao);
        Estoque estoque = new Estoque(idEstoque,quantidadeSomada);
        this.entrada = entrada;
        this.estoque = estoque;
        
    }

    public void registrarEntrada() {
        conexao = ModuloConexao.conector();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        EntradaDAO entradaDao = new EntradaDAO(conexao);
        int linhaSelecionada = telaEntradaPeca.getTblEntradaPeca().getSelectedRow();
        
        if (linhaSelecionada != -1) {
            coletaDadosPreencheVariaveis();
            estoqueDao.acrescentarQuantidadePecaNoEstoque(estoque.getId(), estoque.getQuantidade());
           //System.out.println(estoque.toString());
            entradaDao.registrarDadosDeEntradaNoEstoque(entrada);
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha para registrar a entrada de uma peça ");

        }

    }
}
