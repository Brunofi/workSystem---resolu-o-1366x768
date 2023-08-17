/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.model.Locacao;
import br.com.porschegt3cup.view.TelaLocacao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.DropMode;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bruno
 */
public class TelaLocacaoController {

    private TelaLocacao telaLocacao;
    Connection conexao = null;

    public TelaLocacaoController(TelaLocacao telaLocacao) {
        this.telaLocacao = telaLocacao;
    }

    private void apagarCampos() {
        telaLocacao.getTxtLocacao().setText(null);
        telaLocacao.getTxtSubLocacao().setText(null);
        telaLocacao.getTxtId().setText(null);
        DefaultTableModel tabela = (DefaultTableModel) telaLocacao.getTblLocacao().getModel();
        tabela.setRowCount(0);

    }

    public void inserirLocacao() {
        conexao = ModuloConexao.conector();
        String nome = telaLocacao.getTxtLocacao().getText();
        String sub = telaLocacao.getTxtSubLocacao().getText();
        Locacao locacao = new Locacao(nome, sub);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        locacaoDao.inserirLocacao(locacao);
        apagarCampos();

    }

    public void procurarLocacao() {

        conexao = ModuloConexao.conector();
        String nome = telaLocacao.getTxtLPesquisar().getText();
        Locacao locacao = new Locacao(nome);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        ResultSet rs;
        rs = locacaoDao.pesquisarLocacao(locacao);
        if (rs != null) {
            telaLocacao.getTblLocacao().setModel(DbUtils.resultSetToTableModel(rs));

        } else {
            JOptionPane.showMessageDialog(null, "Locação não encontrada");
        }

    }

    public void alterarLocacao() {
        conexao = ModuloConexao.conector();
        int id = Integer.parseInt(telaLocacao.getTxtId().getText());
        String nome = telaLocacao.getTxtLocacao().getText();
        String sub = telaLocacao.getTxtSubLocacao().getText();
        Locacao locacao = new Locacao(id, nome, sub);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        locacaoDao.alterarLocacao(locacao);
        telaLocacao.getBtnCadastrar().setEnabled(true);
        apagarCampos();

    }

    public void removerLocacao() {
        conexao = ModuloConexao.conector();
        int id = Integer.parseInt(telaLocacao.getTxtId().getText());
        Locacao locacao = new Locacao(id);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        locacaoDao.removerLocacao(locacao);
        telaLocacao.getBtnCadastrar().setEnabled(true);
        apagarCampos();

    }

    public void preencherCampos() {
        telaLocacao.getBtnCadastrar().setEnabled(false);
        int linhaSelecionada = telaLocacao.getTblLocacao().getSelectedRow();
        telaLocacao.getTxtId().setText(telaLocacao.getTblLocacao().getModel().getValueAt(linhaSelecionada, 0).toString());
        telaLocacao.getTxtLocacao().setText(telaLocacao.getTblLocacao().getModel().getValueAt(linhaSelecionada, 1).toString());
        telaLocacao.getTxtSubLocacao().setText(telaLocacao.getTblLocacao().getModel().getValueAt(linhaSelecionada, 2).toString());

    }

}
