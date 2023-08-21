/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.PecaDAO;
import br.com.porschegt3cup.model.Peca;
import br.com.porschegt3cup.view.TelaCadastroPeca;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bruno
 */
public class TelaCadastroPecaController {

    Connection conexao = null;
    private TelaCadastroPeca telaCadastroPeca;

    public TelaCadastroPecaController(TelaCadastroPeca telaCadastroPeca) {
        this.telaCadastroPeca = telaCadastroPeca;
    }

    public void apagarCampos() {
        telaCadastroPeca.getTxtPartNumber().setText(null);
        telaCadastroPeca.getTxtNome().setText(null);
        telaCadastroPeca.getTxtSubSistema().setText(null);
        telaCadastroPeca.getTxtModelo().setText(null);
        telaCadastroPeca.getTxtFabricante().setText(null);
        telaCadastroPeca.getCbEstado().setSelectedItem(null);
        telaCadastroPeca.getTxtPeso().setText(null);
        telaCadastroPeca.getTxtNcm().setText(null);
        telaCadastroPeca.getTxtPreco().setText(null);
        telaCadastroPeca.getTxtPartNumberSimilar().setText(null);
        telaCadastroPeca.getTxtQtdMin().setText(null);
        telaCadastroPeca.getTxtQtdMed().setText(null);
        telaCadastroPeca.getTxtQtdMax().setText(null);
        telaCadastroPeca.getTxtId().setText(null);
        telaCadastroPeca.getBtnCadastrar().setEnabled(true);
        DefaultTableModel tabela = (DefaultTableModel) telaCadastroPeca.getTblPeca().getModel();
        tabela.setRowCount(0);

    }

    public Peca SetaPecaAtravesDeCamposPreenchidos() {

        String partNumber = telaCadastroPeca.getTxtPartNumber().getText();
        String nome = telaCadastroPeca.getTxtNome().getText();
        String subSistema = telaCadastroPeca.getTxtSubSistema().getText();
        String modeloCarro = telaCadastroPeca.getTxtModelo().getText();
        String fabricante = telaCadastroPeca.getTxtFabricante().getText();
        String estado = telaCadastroPeca.getCbEstado().getSelectedItem().toString();
        String peso = telaCadastroPeca.getTxtPeso().getText();
        String ncm = telaCadastroPeca.getTxtNcm().getText();
        String precoString = telaCadastroPeca.getTxtPreco().getText().replaceAll(",", ".");
        BigDecimal preco = new BigDecimal(precoString);
        String partNumberSimilar = telaCadastroPeca.getTxtPartNumberSimilar().getText();
        int qtdMin = Integer.parseInt(telaCadastroPeca.getTxtQtdMin().getText());
        int qtdMed = Integer.parseInt(telaCadastroPeca.getTxtQtdMed().getText());
        int qtdMax = Integer.parseInt(telaCadastroPeca.getTxtQtdMax().getText());
        Peca peca = new Peca(nome, partNumber, peso, ncm, estado, modeloCarro, subSistema, fabricante, qtdMin, qtdMed, qtdMax, preco, partNumberSimilar);
        return peca;

    }

    public void cadastrarPeca() {
        conexao = ModuloConexao.conector();
        Peca peca = new Peca();
        peca = SetaPecaAtravesDeCamposPreenchidos();
        PecaDAO pecaDao = new PecaDAO(conexao);
        pecaDao.inserirPeca(peca);
        apagarCampos();

    }

    public void alterarPrca() {
        conexao = ModuloConexao.conector();
        int id = Integer.parseInt(telaCadastroPeca.getTxtId().getText());
        Peca peca = new Peca();
        peca = SetaPecaAtravesDeCamposPreenchidos();
        peca.setId(id);
        PecaDAO pecaDao = new PecaDAO(conexao);
        pecaDao.alterarPeca(peca);
        apagarCampos();

    }
    
    public void removePeca(){
        conexao = ModuloConexao.conector();
        int id = Integer.parseInt(telaCadastroPeca.getTxtId().getText());
        PecaDAO pecaDao = new PecaDAO(conexao);
        pecaDao.removerPeca(id);
        apagarCampos();
    }

    public void procurarPeca() {
        apagarCampos();
        conexao = ModuloConexao.conector();
        String peca = telaCadastroPeca.getTxtPesquisar().getText();
        PecaDAO pecaDao = new PecaDAO(conexao);
        ResultSet rs;
        
        if (telaCadastroPeca.getrBtnPartNumber().isSelected()) {
            rs = pecaDao.pesquisarPorPartNumber(peca);
        } else {
            rs = pecaDao.pesquisarPorNome(peca);
        }
        
        if (rs != null) {
            telaCadastroPeca.getTblPeca().setModel(DbUtils.resultSetToTableModel(rs));
        } 

    }

    public void buscaPecaSelecionadaNoBanco() {
        conexao = ModuloConexao.conector();
        telaCadastroPeca.getBtnCadastrar().setEnabled(false);
        int linhaSelecionada = telaCadastroPeca.getTblPeca().getSelectedRow();
        int id = Integer.parseInt(telaCadastroPeca.getTblPeca().getModel().getValueAt(linhaSelecionada, 0).toString());//Integer.parseInt(telaCadastroPeca.getTxtId().getText());
        PecaDAO pecaDao = new PecaDAO(conexao);
        Peca pecaProcurada = new Peca();
        pecaProcurada = pecaDao.pesquisarPorId(id);
        preencheCamposAtravesDeUmObjetoPeca(pecaProcurada);

    }

    public void preencheCamposAtravesDeUmObjetoPeca(Peca peca) {
        telaCadastroPeca.getTxtPartNumber().setText(peca.getPartNumber());
        telaCadastroPeca.getTxtNome().setText(peca.getNome());
        telaCadastroPeca.getTxtSubSistema().setText(peca.getSubSistema());
        telaCadastroPeca.getTxtModelo().setText(peca.getModeloCarro());
        telaCadastroPeca.getTxtFabricante().setText(peca.getFabricante());
        telaCadastroPeca.getCbEstado().setSelectedItem(peca.getEstado());
        telaCadastroPeca.getTxtPeso().setText(peca.getPeso());
        telaCadastroPeca.getTxtNcm().setText(peca.getNcm());
        String preco = String.valueOf(peca.getPreco().toString().replaceAll("\\.", ","));
        telaCadastroPeca.getTxtPreco().setText(preco);
        telaCadastroPeca.getTxtPartNumberSimilar().setText(peca.getPartNumberSimilar());
        String qtdmin = String.valueOf(peca.getQtdMin());
        String qtdmed = String.valueOf(peca.getQtdMed());
        String qtdmax = String.valueOf(peca.getQtdMax());
        String idString = String.valueOf(peca.getId());
        telaCadastroPeca.getTxtQtdMin().setText(qtdmin);
        telaCadastroPeca.getTxtQtdMed().setText(qtdmed);
        telaCadastroPeca.getTxtQtdMax().setText(qtdmax);
        telaCadastroPeca.getTxtId().setText(idString);

    }

}
