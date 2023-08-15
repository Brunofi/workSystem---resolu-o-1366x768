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
import javax.swing.JOptionPane;
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
    
    private void apagarCampos(){
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
            
    
    }
    
    public void cadastrarPeca(){
        conexao = ModuloConexao.conector();
        String partNumber = telaCadastroPeca.getTxtPartNumber().getText();
        String nome = telaCadastroPeca.getTxtNome().getText();
        String subSistema = telaCadastroPeca.getTxtSubSistema().getText();
        String modeloCarro = telaCadastroPeca.getTxtModelo().getText();
        String fabricante = telaCadastroPeca.getTxtFabricante().getText();
        String estado = telaCadastroPeca.getCbEstado().getSelectedItem().toString();
        String peso = telaCadastroPeca.getTxtPeso().getText();
        String ncm = telaCadastroPeca.getTxtNcm().getText();
        String precoString = telaCadastroPeca.getTxtPreco().getText().replaceAll(",", ".");
        BigDecimal preco  = new BigDecimal(precoString);
        String partNumberSimilar = telaCadastroPeca.getTxtPartNumberSimilar().getText();
        int qtdMin = Integer.parseInt(telaCadastroPeca.getTxtQtdMin().getText());
        int qtdMed = Integer.parseInt(telaCadastroPeca.getTxtQtdMed().getText());
        int qtdMax = Integer.parseInt(telaCadastroPeca.getTxtQtdMax().getText());
        Peca peca = new Peca(nome, partNumber, peso, ncm, estado, modeloCarro, subSistema, fabricante, qtdMin, qtdMed, qtdMax, preco, partNumberSimilar);
        PecaDAO pecaDao = new PecaDAO(conexao);
        pecaDao.inserirPeca(peca);
        apagarCampos();
        
        
    }
    
    public void procurarPeca(){
        conexao = ModuloConexao.conector();
        String pecaPesquisada = telaCadastroPeca.getTxtLPesquisar().getText();
        Peca peca = new Peca(pecaPesquisada);
        PecaDAO pecaDao = new PecaDAO(conexao);
        ResultSet rs;
        rs = pecaDao.pesquisarPorPartNumber(peca);
        if (rs != null) {
            telaCadastroPeca.getTblPeca().setModel(DbUtils.resultSetToTableModel(rs));
            
        } else {
            JOptionPane.showMessageDialog(null, "Peça não encontrada");
        }
    
    }
    
    
    
}
