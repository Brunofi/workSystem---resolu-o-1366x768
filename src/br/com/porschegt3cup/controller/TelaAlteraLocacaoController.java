/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.model.Locacao;
import br.com.porschegt3cup.view.TelaAlteraLocacao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaAlteraLocacaoController {

    private TelaAlteraLocacao telaAlteraLocacao;
    Connection conexao = null;

    public TelaAlteraLocacaoController(TelaAlteraLocacao telaAlteraLocacao) {
        this.telaAlteraLocacao = telaAlteraLocacao;
    }
    
    int idEstoque=0;
    int idlocacao=0;

    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaAlteraLocacao.getTxtLPesquisarPeca().getText();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs;

        if (telaAlteraLocacao.getrBtnPartNumber().isSelected()) {
            rs = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
        } else {
            rs = estoqueDao.procurarPecaEstoquePorDescricao(peca);
        }

        if (rs != null) {
            telaAlteraLocacao.getTblPeca().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaAlteraLocacao.getTblPeca());
        }

    }

    public void procurarLocacao() {

        conexao = ModuloConexao.conector();
        String nome = telaAlteraLocacao.getTxtLPesquisarLocacao().getText();
        Locacao locacao = new Locacao(nome);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        ResultSet rs;
        rs = locacaoDao.pesquisarLocacao(locacao);
        if (rs != null) {
            telaAlteraLocacao.getTblLocacao().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaAlteraLocacao.getTblLocacao());
        }

    }

    public void apagarCamposPeca() {

        telaAlteraLocacao.getTxtLPesquisarPeca().setText(null);
        DefaultTableModel tabela = (DefaultTableModel) telaAlteraLocacao.getTblPeca().getModel();
        tabela.setRowCount(0);

    }

    public void apagarCamposLocacao() {

        telaAlteraLocacao.getTxtLPesquisarLocacao().setText(null);
        DefaultTableModel tabela = (DefaultTableModel) telaAlteraLocacao.getTblLocacao().getModel();
        tabela.setRowCount(0);

    }

    public void coletaDadosPreencheVariaveis() {
        if (Utils.linhaSelecionadaContemDados(telaAlteraLocacao.getTblPeca()) && Utils.linhaSelecionadaContemDados(telaAlteraLocacao.getTblLocacao())) {
            int linhaSelecionadaTabelaPeca = telaAlteraLocacao.getTblPeca().getSelectedRow();
            int linhaSelecionadaTabelaLocacao = telaAlteraLocacao.getTblLocacao().getSelectedRow();
             idEstoque = Integer.parseInt(telaAlteraLocacao.getTblPeca().getModel().getValueAt(linhaSelecionadaTabelaPeca, 6).toString());
             idlocacao = Integer.parseInt(telaAlteraLocacao.getTblLocacao().getModel().getValueAt(linhaSelecionadaTabelaLocacao, 0).toString());
            
         }else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha em cada tabela com dados para alterar uma locação ");

        }

    }
    
    public void alterarLocacao(){
        coletaDadosPreencheVariaveis();
        if((idEstoque!=0) && (idlocacao!=0)){
            
            conexao = ModuloConexao.conector();
            EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
            estoqueDao.alterarLocacaoEstoque(idEstoque, idlocacao);
            idEstoque = 0;
            idlocacao = 0;
            apagarCamposPeca();
            apagarCamposLocacao();
        
        }else {
            JOptionPane.showMessageDialog(null, "Falha ao coletar o ID do estoque ou o ID da locação, tente novamete ");

        }
    
    
    
    }
}
