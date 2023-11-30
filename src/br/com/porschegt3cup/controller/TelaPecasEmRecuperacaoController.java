/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.RecuperacaoPecaControleDAO;
import br.com.porschegt3cup.view.TelaPecasEmRecuperacao;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaPecasEmRecuperacaoController {

    Connection conexao = null;
    private TelaPecasEmRecuperacao telaPecasEmRecuperacao;

    public TelaPecasEmRecuperacaoController(TelaPecasEmRecuperacao telaPecasEmRecuperacao) {
        this.telaPecasEmRecuperacao = telaPecasEmRecuperacao;
    }

    public void procurarPecas() {
        conexao = ModuloConexao.conector();
        String peca = telaPecasEmRecuperacao.getTxtLPesquisar().getText();
        String setor;
        String situacao;
        RecuperacaoPecaControleDAO recuperacaoPecaControleDAO = new RecuperacaoPecaControleDAO(conexao);
        ResultSet rs = null;
        telaPecasEmRecuperacao.getBtnAtualizar().setEnabled(false);

       //se part number estiver selecionado
        if (telaPecasEmRecuperacao.getrBtnPartNumber().isSelected()
                && telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
             //se nenhum filtro estiver preenchido
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorPartNumber(peca);

        } else if (telaPecasEmRecuperacao.getrBtnPartNumber().isSelected()
                && !telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && !telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se os dois filtros estiverem preenchidos
            situacao = telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString();
            setor = telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorPartNumberESituacaoESetor(peca, situacao, setor);
        } else if (telaPecasEmRecuperacao.getrBtnPartNumber().isSelected()
                && telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && !telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se só a situação estiver preenchida
            situacao = telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorPartNumberESituacao(peca, situacao);

        } else if (telaPecasEmRecuperacao.getrBtnPartNumber().isSelected()
                && !telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se só o setor estiver preenchida
            setor = telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorPartNumberESetor(peca, setor);

        }
        
        //se Descricao estiver selecionado
        if (telaPecasEmRecuperacao.getrBtnDescricao().isSelected()
                && telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
             //se nenhum filtro estiver preenchido
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorDescricao(peca);

        } else if (telaPecasEmRecuperacao.getrBtnDescricao().isSelected()
                && !telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && !telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se os dois filtros estiverem preenchidos
            situacao = telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString();
            setor = telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorDescricaoESituacaoESetor(peca, situacao, setor);
            
        } else if (telaPecasEmRecuperacao.getrBtnDescricao().isSelected()
                && telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && !telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se só a situação estiver preenchida
            situacao = telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorDescricaoESituacao(peca, situacao);

        } else if (telaPecasEmRecuperacao.getrBtnDescricao().isSelected()
                && !telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString().trim().isEmpty()
                && telaPecasEmRecuperacao.getCbFiltroSituacao().getSelectedItem().toString().trim().isEmpty()) {
            //se só o setor estiver preenchida
            setor = telaPecasEmRecuperacao.getCbFiltroSetor().getSelectedItem().toString();
            rs = recuperacaoPecaControleDAO.procurarPecasTabelaRecuperacaoPorDescricaoESetor(peca, setor);

        }

        if (rs != null) {
            telaPecasEmRecuperacao.getTblPecasEmRecuperacao().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaPecasEmRecuperacao.getTblPecasEmRecuperacao());

        } else {

            limparBusca();
        }
    }

    public void preencherCampos() {
        if (Utils.linhaSelecionadaContemDados(telaPecasEmRecuperacao.getTblPecasEmRecuperacao())) {
            telaPecasEmRecuperacao.getBtnAtualizar().setEnabled(true);
            int linhaSelecionada = telaPecasEmRecuperacao.getTblPecasEmRecuperacao().getSelectedRow();
            telaPecasEmRecuperacao.getTxtidRecuperacao().setText(telaPecasEmRecuperacao.getTblPecasEmRecuperacao().getModel().getValueAt(linhaSelecionada, 0).toString());
        } else {
            JOptionPane.showMessageDialog(null, "è necessario conter dados selecionados para realizar a operação");

        }
    }

    public void atualizarStatusPeca() {
        if (Utils.linhaSelecionadaContemDados(telaPecasEmRecuperacao.getTblPecasEmRecuperacao())) {
            conexao = ModuloConexao.conector();
            int id = Integer.parseInt(telaPecasEmRecuperacao.getTxtidRecuperacao().getText());
            String setor = telaPecasEmRecuperacao.getCbAtualizarSetor().getSelectedItem().toString();
            String situacao = telaPecasEmRecuperacao.getCbAtualizarSituacao().getSelectedItem().toString();
            RecuperacaoPecaControleDAO recuperacaoPecaControleDAO = new RecuperacaoPecaControleDAO(conexao);
            recuperacaoPecaControleDAO.atualizarStatusPecaEmRecuperacao(id, situacao, setor);
            //aqui tem que chamar o código para buscar peças seguindo o mesmo filro que ja se encontra preenchido
            apagarCamposAtualizarBusca();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário que a linha selecionada contenha dados para prosseguir");
        }
    }

    public void apagarCamposAtualizarBusca() {
        telaPecasEmRecuperacao.getTxtidRecuperacao().setText(null);
        telaPecasEmRecuperacao.getCbAtualizarSetor().setSelectedIndex(0);
        telaPecasEmRecuperacao.getCbAtualizarSituacao().setSelectedIndex(0);
        procurarPecas();

    }

    public void limparBusca() {

        telaPecasEmRecuperacao.getTxtLPesquisar().setText(null);
        telaPecasEmRecuperacao.getCbFiltroSetor().setSelectedIndex(0);
        telaPecasEmRecuperacao.getCbFiltroSituacao().setSelectedIndex(0);

        telaPecasEmRecuperacao.getTxtidRecuperacao().setText(null);
        telaPecasEmRecuperacao.getCbAtualizarSetor().setSelectedIndex(0);
        telaPecasEmRecuperacao.getCbAtualizarSituacao().setSelectedIndex(0);

        DefaultTableModel tabela = (DefaultTableModel) telaPecasEmRecuperacao.getTblPecasEmRecuperacao().getModel();
        tabela.setRowCount(0);

    }

}
