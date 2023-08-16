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

    private void apagarCampos() {
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

    public void cadastrarPeca() {
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
        BigDecimal preco = new BigDecimal(precoString);
        String partNumberSimilar = telaCadastroPeca.getTxtPartNumberSimilar().getText();
        int qtdMin = Integer.parseInt(telaCadastroPeca.getTxtQtdMin().getText());
        int qtdMed = Integer.parseInt(telaCadastroPeca.getTxtQtdMed().getText());
        int qtdMax = Integer.parseInt(telaCadastroPeca.getTxtQtdMax().getText());
        Peca peca = new Peca(nome, partNumber, peso, ncm, estado, modeloCarro, subSistema, fabricante, qtdMin, qtdMed, qtdMax, preco, partNumberSimilar);
        PecaDAO pecaDao = new PecaDAO(conexao);
        pecaDao.inserirPeca(peca);
        apagarCampos();

    }

    public void procurarPeca() {
        conexao = ModuloConexao.conector();
        String peca = telaCadastroPeca.getTxtLPesquisar().getText();
        PecaDAO pecaDao = new PecaDAO(conexao);
        ResultSet rs;
        rs = pecaDao.pesquisarPorPartNumber(peca);
        if (rs != null) {
            telaCadastroPeca.getTblPeca().setModel(DbUtils.resultSetToTableModel(rs));

        } else {
            JOptionPane.showMessageDialog(null, "Peça não encontrada");
        }

    }

    public void pegaPecaSelecionadaEPreencheCampos() throws SQLException {
        telaCadastroPeca.getBtnCadastrar().setEnabled(false);
        int linhaSelecionada = telaCadastroPeca.getTblPeca().getSelectedRow();
        int id = Integer.parseInt(telaCadastroPeca.getTblPeca().getModel().getValueAt(linhaSelecionada, 0).toString());//Integer.parseInt(telaCadastroPeca.getTxtId().getText());
        System.out.println(id);
        Peca peca = new Peca();
        
            peca = buscarObjetoPecaNoBanco(id);
            telaCadastroPeca.getTxtPartNumber().setText(peca.getPartNumber());
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

        
            JOptionPane.showMessageDialog(null, "Peça não encontrada");
        

    }

    public Peca buscarObjetoPecaNoBanco(int id) throws SQLException {
        conexao = ModuloConexao.conector();
        PecaDAO pecaDao = new PecaDAO(conexao);
        System.out.println("o id do metodo buscarObjetoPecaNoBanco é:" + id);
        ResultSet resultSet = pecaDao.pesquisarPorId(id);
        Peca peca = new Peca();
        peca.setId(resultSet.getInt("id"));
        System.out.println("O id do objeto pça é" + peca.getId());
        /*
        peca.setNome(resultSet.getString("nome"));
        peca.setPartNumber(resultSet.getString("partnumber"));
        peca.setPeso(resultSet.getString("peso"));
        peca.setNcm(resultSet.getString("ncm"));
        peca.setEstado(resultSet.getString("estado"));
        peca.setModeloCarro(resultSet.getString("modelocarro"));
        peca.setFabricante(resultSet.getString("fabricante"));
        peca.setQtdMin(resultSet.getInt("qtdmin"));
        peca.setQtdMed(resultSet.getInt("qtdmed"));
        peca.setQtdMax(resultSet.getInt("qtdmax"));
        peca.setPreco(resultSet.getBigDecimal("preco"));
        peca.setPartNumberSimilar(resultSet.getString("ptnumber_similar"));
*/
        return peca;

    }

}
