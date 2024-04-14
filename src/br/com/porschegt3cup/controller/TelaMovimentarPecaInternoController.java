/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.view.TelaMovimentarPecaInterno;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaMovimentarPecaInternoController {

    private TelaMovimentarPecaInterno telaMovimentarPecaInterno;
    Connection conexao = null;

    public TelaMovimentarPecaInternoController(TelaMovimentarPecaInterno telaMovimentarPecaInterno) {
        this.telaMovimentarPecaInterno = telaMovimentarPecaInterno;
    }

    Integer quantidadeDebto;
    Integer quantidadeAcrescimo;
    Integer idEstoqueDebto;
    Integer idEstoqueAcrescimo;
    Integer idPecaDebto;
    Integer IdPecaAcrescimo;
    Integer quantidadeMovimentacao;

    public void apagarCampos() {
        telaMovimentarPecaInterno.getTxtLPesquisar().setText(null);
        telaMovimentarPecaInterno.getTxtQuantidadeEntrada().setText(null);
        DefaultTableModel tabelaacrescimo = (DefaultTableModel) telaMovimentarPecaInterno.getTblEstoqueAcrescimo().getModel();
        tabelaacrescimo.setRowCount(0);
        DefaultTableModel tabelaDebto = (DefaultTableModel) telaMovimentarPecaInterno.getTblEstoqueDebto().getModel();
        tabelaDebto.setRowCount(0);

    }

    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaMovimentarPecaInterno.getTxtLPesquisar().getText();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs1, rs2;

        if (telaMovimentarPecaInterno.getrBtnPartNumber().isSelected()) {
            rs1 = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
            rs2 = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
        } else {
            rs1 = estoqueDao.procurarPecaEstoquePorDescricao(peca);
            rs2 = estoqueDao.procurarPecaEstoquePorDescricao(peca);
        }

        if (rs1 != null) {
            telaMovimentarPecaInterno.getTblEstoqueAcrescimo().setModel(DbUtils.resultSetToTableModel(rs1));
            Utils.ajustarLarguraColunas(telaMovimentarPecaInterno.getTblEstoqueAcrescimo());

            telaMovimentarPecaInterno.getTblEstoqueDebto().setModel(DbUtils.resultSetToTableModel(rs2));
            Utils.ajustarLarguraColunas(telaMovimentarPecaInterno.getTblEstoqueDebto());

        }

    }

   
    public boolean verificaPecaIgual() {
        if (idPecaDebto != null && IdPecaAcrescimo != null && idPecaDebto.equals(IdPecaAcrescimo)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Para movimentar a peça é necessario que as duas peças sejam iguais");
            return false;
        }
    }

    public boolean verificarLocacaoDiferente() {
        if (!idEstoqueDebto.equals(idEstoqueAcrescimo)) {
            return true;

        } else {
            JOptionPane.showMessageDialog(null, "Para movimentar a peça é necessario que as duas locações sejam diferentes");
            return false;
        }

    }

    public boolean verificaQuantidades() {
        if (quantidadeMovimentacao > quantidadeDebto) {
            JOptionPane.showMessageDialog(null, "A quantidade que vai ser movimentada não pode ser maior que o estoque selecionado");
            return false;
        } else {
            quantidadeDebto = quantidadeDebto - quantidadeMovimentacao;
            quantidadeAcrescimo = quantidadeAcrescimo + quantidadeMovimentacao;
            return true;

        }

    }

    public void registrarMovimentacao() {

        if (Utils.linhaSelecionadaContemDados(telaMovimentarPecaInterno.getTblEstoqueAcrescimo()) && Utils.linhaSelecionadaContemDados(telaMovimentarPecaInterno.getTblEstoqueDebto())) {
            coletaDadosPreencheVariaveis();
            if (verificaPecaIgual()==true) {
                if (verificarLocacaoDiferente()) {
                     if (verificaQuantidades()) {
                        conexao = ModuloConexao.conector();
                        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
                        estoqueDao.alterarQuantidadePecaEstoque(idEstoqueDebto, quantidadeDebto);
                        estoqueDao.alterarQuantidadePecaEstoque(idEstoqueAcrescimo, quantidadeAcrescimo);
                        apagarCampos();
                        JOptionPane.showMessageDialog(null, "Operação realizada com sucesso");

                    }
                }
            }
        }else{
             JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha em cada tabela com dados para registrar a movimentação de uma peça ");
        
        }
    
}

public void coletaDadosPreencheVariaveis() {
        int linhaSelecionadaTabelaDebto = telaMovimentarPecaInterno.getTblEstoqueDebto().getSelectedRow();
        int linhaSelecionadaTabelaAcrescimo = telaMovimentarPecaInterno.getTblEstoqueAcrescimo().getSelectedRow();

        quantidadeDebto = Integer.parseInt(telaMovimentarPecaInterno.getTblEstoqueDebto().getModel().getValueAt(linhaSelecionadaTabelaDebto, 3).toString());
        quantidadeAcrescimo = Integer.parseInt(telaMovimentarPecaInterno.getTblEstoqueAcrescimo().getModel().getValueAt(linhaSelecionadaTabelaAcrescimo, 3).toString());
        
        idEstoqueDebto = Integer.parseInt( telaMovimentarPecaInterno.getTblEstoqueDebto().getModel().getValueAt(linhaSelecionadaTabelaDebto, 6).toString());
        idEstoqueAcrescimo = Integer.parseInt( telaMovimentarPecaInterno.getTblEstoqueAcrescimo().getModel().getValueAt(linhaSelecionadaTabelaAcrescimo, 6).toString());
        
        idPecaDebto = Integer.parseInt(telaMovimentarPecaInterno.getTblEstoqueDebto().getModel().getValueAt(linhaSelecionadaTabelaDebto, 7).toString());
        IdPecaAcrescimo = Integer.parseInt(telaMovimentarPecaInterno.getTblEstoqueAcrescimo().getModel().getValueAt(linhaSelecionadaTabelaAcrescimo, 7).toString());
        
        quantidadeMovimentacao = Integer.parseInt(telaMovimentarPecaInterno.getTxtQuantidadeMovimentada().getText());
        
        
    }

}
