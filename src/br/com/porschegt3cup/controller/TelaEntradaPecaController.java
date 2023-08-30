/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

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
    String colaborador;
    Entrada entrada = null;
    Estoque estoque = null;

    public TelaEntradaPecaController(TelaEntradaPeca telaEntradaPeca) {
        this.telaEntradaPeca = telaEntradaPeca;
    }

    public void descobreColaborador() {
        colaborador = TelaLoginController.colaborador;
        System.out.println(colaborador);

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
        colaborador = TelaLoginController.colaborador;
        int linhaSelecionada = telaEntradaPeca.getTblEntradaPeca().getSelectedRow();
        //String partNumber = telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 0).toString();
        //String nomePeca = telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 1).toString();
        int quantidadeEntrada = Integer.parseInt(telaEntradaPeca.getTxtQuantidadeEntrada().getText());
        String motivo = telaEntradaPeca.getCbMotivo().getSelectedItem().toString();
        String observacao = telaEntradaPeca.getTxtObservacao().getText();
        int idEstoque = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 5).toString());
        int idPeca = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 6).toString());
        int idlocacao = Integer.parseInt(telaEntradaPeca.getTblEntradaPeca().getModel().getValueAt(linhaSelecionada, 7).toString());
        Entrada entrada = new Entrada(quantidadeEntrada, motivo, colaborador, observacao, idPeca, idlocacao);
        Estoque estoque = new Estoque(quantidadeEntrada, idPeca, idlocacao);
        this.entrada = entrada;
        this.estoque = estoque;
    }

    public void registrarEntrada() {
        int linhaSelecionada = telaEntradaPeca.getTblEntradaPeca().getSelectedRow();
        
        if (linhaSelecionada != -1) {
            coletaDadosPreencheVariaveis();
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha para registrar a entrada de uma peça ");

        }

    }
}
