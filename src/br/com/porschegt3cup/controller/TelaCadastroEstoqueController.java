/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.PecaDAO;
import br.com.porschegt3cup.model.Locacao;
import br.com.porschegt3cup.view.TelaCadastroEstoque;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaCadastroEstoqueController {

    Connection conexao = null;
    private TelaCadastroEstoque telaCadastroEstoque;
    private int idPeca;
    private int idLocacao;

    public TelaCadastroEstoqueController(TelaCadastroEstoque telaCadastroEstoque) {
        this.telaCadastroEstoque = telaCadastroEstoque;
    }

    public void apagarCamposPeca() {

        telaCadastroEstoque.getTxtPesquisaPeca().setText(null);
        DefaultTableModel tabelaPeca = (DefaultTableModel) telaCadastroEstoque.getTblPecas().getModel();
        tabelaPeca.setRowCount(0);
        idPeca = 0;

    }

    public void apagarCamposLocacao() {
        telaCadastroEstoque.getTxtPesquisaLocacao().setText(null);
        DefaultTableModel tabelaLocacao = (DefaultTableModel) telaCadastroEstoque.getTblLocacao().getModel();
        tabelaLocacao.setRowCount(0);
        idLocacao = 0;

    }

    public void procurarPeca() {
        conexao = ModuloConexao.conector();
        String peca = telaCadastroEstoque.getTxtPesquisaPeca().getText();
        PecaDAO pecaDao = new PecaDAO(conexao);
        ResultSet rs;
        if (telaCadastroEstoque.getrBtnPartNumber().isSelected()) {
            rs = pecaDao.pesquisarPorPartNumber(peca);

        } else {
            rs = pecaDao.pesquisarPorNome(peca);
        }

        if (rs != null) {
            telaCadastroEstoque.getTblPecas().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaCadastroEstoque.getTblPecas());
        }

    }

    public void procurarLocacao() {

        conexao = ModuloConexao.conector();
        String nome = telaCadastroEstoque.getTxtPesquisaLocacao().getText();
        Locacao locacao = new Locacao(nome);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        ResultSet rs;
        rs = locacaoDao.pesquisarLocacao(locacao);
        if (rs != null) {
            telaCadastroEstoque.getTblLocacao().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaCadastroEstoque.getTblLocacao());

        } else {
            JOptionPane.showMessageDialog(null, "Locação não encontrada");
        }

    }

    public void preencherIdPeca() {
        int linhaSelecionada = telaCadastroEstoque.getTblPecas().getSelectedRow();
        idPeca = Integer.parseInt(telaCadastroEstoque.getTblPecas().getModel().getValueAt(linhaSelecionada, 0).toString());
        //telaCadastroEstoque.getTxtIdPeca().setText(telaCadastroEstoque.getTblPecas().getModel().getValueAt(linhaSelecionada, 0).toString());

    }

    public void preencherIdLocacao() {
        int linhaSelecionada = telaCadastroEstoque.getTblLocacao().getSelectedRow();
        idLocacao = Integer.parseInt(telaCadastroEstoque.getTblLocacao().getModel().getValueAt(linhaSelecionada, 0).toString());
        //telaCadastroEstoque.getTxtIdLocacao().setText(telaCadastroEstoque.getTblLocacao().getModel().getValueAt(linhaSelecionada, 0).toString());

    }

    public void cadastrarPecaNoEstoque() {
        if (Utils.linhaSelecionadaContemDados(telaCadastroEstoque.getTblPecas()) && (Utils.linhaSelecionadaContemDados(telaCadastroEstoque.getTblLocacao()))) {
            conexao = ModuloConexao.conector();
            EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
            preencherIdPeca();
            preencherIdLocacao();
            estoqueDao.inserirPecaNoEstoque(0, idPeca, idLocacao);
            apagarCamposLocacao();
            apagarCamposPeca();

        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar uma peça e uma locação para criar estoque ");

        }
        

    }

}
