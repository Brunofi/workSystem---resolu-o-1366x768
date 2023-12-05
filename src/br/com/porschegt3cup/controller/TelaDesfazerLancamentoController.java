/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.RecuperacaoPecaControleDAO;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.view.TelaDesfazerLancamento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaDesfazerLancamentoController {
    
    Connection conexao = null;
    private TelaDesfazerLancamento telaDesfazerLancamento;

    public TelaDesfazerLancamentoController(TelaDesfazerLancamento telaDesfazerLancamento) {
        this.telaDesfazerLancamento = telaDesfazerLancamento;
    }
    
    public void carregarListaDeChassis() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = saidaDao.buscarListaDeChassis();
        telaDesfazerLancamento.getCbFiltroChassis().addItem("");
        for (String chassis : listaChassis) {
            telaDesfazerLancamento.getCbFiltroChassis().addItem(chassis);
        }
        
    }
    public void carregarListaDeEtapas() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaEtapas = saidaDao.buscarListaDeEtapas();
        telaDesfazerLancamento.getCbFiltroEtaoa().addItem("");
        for (String etapa : listaEtapas) {
            telaDesfazerLancamento.getCbFiltroEtaoa().addItem(etapa);
        }
    }
    
    public void bucarPecas(){
        
        conexao = ModuloConexao.conector();
        String chassis = telaDesfazerLancamento.getCbFiltroChassis().getSelectedItem().toString();
        String etapa = telaDesfazerLancamento.getCbFiltroEtaoa().getSelectedItem().toString();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        ResultSet rs = saidaDao.procurarLancamentoPecasPorChassisEEtapa(chassis, etapa);
        
        if(rs!=null){
            telaDesfazerLancamento.getBtnDesfazer().setEnabled(false);
            telaDesfazerLancamento.getTblPecasLancadas().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaDesfazerLancamento.getTblPecasLancadas());
        }else{
            limparBusca();
        }
        
    }
    
    
    
    public void preencherCampos(){
        if (Utils.linhaSelecionadaContemDados(telaDesfazerLancamento.getTblPecasLancadas())) {
            int linhaSelecionada = telaDesfazerLancamento.getTblPecasLancadas().getSelectedRow();
            telaDesfazerLancamento.getTxtidSaida().setText(telaDesfazerLancamento.getTblPecasLancadas().getModel().getValueAt(linhaSelecionada, 7).toString());
            telaDesfazerLancamento.getTxtidEstoque().setText(telaDesfazerLancamento.getTblPecasLancadas().getModel().getValueAt(linhaSelecionada, 8).toString());
            telaDesfazerLancamento.getTxtQtdRetornoEstoque().setText(telaDesfazerLancamento.getTblPecasLancadas().getModel().getValueAt(linhaSelecionada, 3).toString());
            telaDesfazerLancamento.getBtnDesfazer().setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "è necessario conter dados selecionados para realizar a operação");
        }
        
    }
    
    public void desfazerLancamento(){
        conexao = ModuloConexao.conector();
        int idEstoque = Integer.parseInt(telaDesfazerLancamento.getTxtidEstoque().getText());
        int idSaida = Integer.parseInt(telaDesfazerLancamento.getTxtidSaida().getText());
        int quantidadeRetorno = Integer.parseInt(telaDesfazerLancamento.getTxtQtdRetornoEstoque().getText());
        //retorna quantidade para estoque
        EstoqueDAO estoqueDAO = new EstoqueDAO(conexao);
        estoqueDAO.adicionarQuantidadePecaNoEstoque(idEstoque, quantidadeRetorno);
        //apaga infos de peça primero da tabela de recuperação
        RecuperacaoPecaControleDAO recuperacaoPecaControleDAO = new RecuperacaoPecaControleDAO(conexao);
        recuperacaoPecaControleDAO.deletarPecaEmRecuperacao(idSaida);
        //apaga infos de peça da tabela de saida de peças
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        saidaDao.apagarRegistroDePecaLancada(idSaida);
        
        limpaDadosLancamento();
        bucarPecas();
    
    }
    
    public void limparBusca() {
        telaDesfazerLancamento.getCbFiltroChassis().setSelectedIndex(0);
        telaDesfazerLancamento.getCbFiltroEtaoa().setSelectedIndex(0);
        telaDesfazerLancamento.getTxtQtdRetornoEstoque().setText(null);
        telaDesfazerLancamento.getTxtidEstoque().setText(null);
        telaDesfazerLancamento.getTxtidSaida().setText(null);
    
       DefaultTableModel tabela = (DefaultTableModel) telaDesfazerLancamento.getTblPecasLancadas().getModel();
        tabela.setRowCount(0);

    }
    
    public void limpaDadosLancamento(){
        telaDesfazerLancamento.getTxtQtdRetornoEstoque().setText(null);
        telaDesfazerLancamento.getTxtidEstoque().setText(null);
        telaDesfazerLancamento.getTxtidSaida().setText(null);
        
    }
    
    
    
}
