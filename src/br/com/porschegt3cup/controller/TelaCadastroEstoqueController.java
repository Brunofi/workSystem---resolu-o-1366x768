/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.PecaDAO;
import br.com.porschegt3cup.model.Locacao;
import br.com.porschegt3cup.view.TelaCadastroEstoque;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaCadastroEstoqueController {

    Connection conexao = null;
    private TelaCadastroEstoque telaCadastroEstoque;

    public TelaCadastroEstoqueController(TelaCadastroEstoque telaCadastroEstoque) {
        this.telaCadastroEstoque = telaCadastroEstoque;
    }

    public void procurarPeca() {
        conexao = ModuloConexao.conector();
        String peca = telaCadastroEstoque.getTxtPesquisaPeca().getText();
        PecaDAO pecaDao = new PecaDAO(conexao);
        ResultSet rs = pecaDao.pesquisarPorPartNumber(peca);
        if (rs != null) {
            telaCadastroEstoque.getTblPeca().setModel(DbUtils.resultSetToTableModel(rs));

        } else {
            JOptionPane.showMessageDialog(null, "Peça não encontrada");
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

        } else {
            JOptionPane.showMessageDialog(null, "Locação não encontrada");
        }

    }
    
    public void preencherIdPeca() {
        int linhaSelecionada = telaCadastroEstoque.getTblPeca().getSelectedRow();
        telaCadastroEstoque.getTxtIdPeca().setText(telaCadastroEstoque.getTblPeca().getModel().getValueAt(linhaSelecionada, 0).toString());
       
    }
    
    public void preencherIdLocacao() {
        int linhaSelecionada = telaCadastroEstoque.getTblLocacao().getSelectedRow();
        telaCadastroEstoque.getTxtIdLocacao().setText(telaCadastroEstoque.getTblLocacao().getModel().getValueAt(linhaSelecionada, 0).toString());
       
    }

}
