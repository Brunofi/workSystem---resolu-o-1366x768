/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.OrcamentoDAO;
import br.com.porschegt3cup.dao.PecaDAO;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.model.Orcamento;
import br.com.porschegt3cup.view.TelaPedidoPeca;
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
public class TelaPedidoPecaController {
    
    private TelaPedidoPeca telaPedidoPeca;
    Connection conexao = null;

   
    public TelaPedidoPecaController(TelaPedidoPeca telaPedidoPeca) {
        this.telaPedidoPeca = telaPedidoPeca;
    }
    
    public void carregarListaDeChassisSaida() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        telaPedidoPeca.getCbChassis().addItem("");
        for (String chassis : listaChassis) {
            telaPedidoPeca.getCbChassis().addItem(chassis);
        }
    }
    
    public List<String> carregarChassis() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        return saidaDao.buscarListaDeChassis();
    }
    
    public void carregarListaDeSessoes() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaSessoes = saidaDao.buscarListaDeSessoes();
        telaPedidoPeca.getCbSessao().addItem("");
        for (String sessao : listaSessoes) {
            telaPedidoPeca.getCbSessao().addItem(sessao);
        }
    }
    
    public void carregarListaDeEtapas() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaEtapas = saidaDao.buscarListaDeEtapas();
        telaPedidoPeca.getCbEtapa().addItem("");
        for (String etapa : listaEtapas) {
            telaPedidoPeca.getCbEtapa().addItem(etapa);
        }
    }
    
    public void carregarListaMotivo() {
        telaPedidoPeca.getCbMotivo().addItem("");
        telaPedidoPeca.getCbMotivo().addItem("AVARIA");
        telaPedidoPeca.getCbMotivo().addItem("MANUTENCAO");
        
    }
    
    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaPedidoPeca.getTxtLPesquisar().getText();
        PecaDAO pecasDAO = new PecaDAO(conexao);
        ResultSet rs;
        
        rs = pecasDAO.procurarPecaRetorna2Colunas(peca);
        
        if (rs != null) {
            telaPedidoPeca.getTblSolicitarPecas().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaPedidoPeca.getTblSolicitarPecas());
            
        }
        
    }
    
    public Orcamento setaOrcamentoAtravesDeCamposPreenchidos() {
        int linhaSelecionada = telaPedidoPeca.getTblSolicitarPecas().getSelectedRow();
        
        String partNumber = telaPedidoPeca.getTblSolicitarPecas().getModel().getValueAt(linhaSelecionada, 0).toString();
        String nomePeca = telaPedidoPeca.getTblSolicitarPecas().getModel().getValueAt(linhaSelecionada, 1).toString();
        String chassis = telaPedidoPeca.getCbChassis().getSelectedItem().toString();
        String etapa = telaPedidoPeca.getCbEtapa().getSelectedItem().toString();
        String sessao = telaPedidoPeca.getCbSessao().getSelectedItem().toString();
        String motivo = telaPedidoPeca.getCbMotivo().getSelectedItem().toString();
        String numeroMotorCambio = telaPedidoPeca.getTxtNumeroMotorCambio().getText();
        String eixoLado = telaPedidoPeca.getCbLado().getSelectedItem().toString();
        int quantidade = Integer.parseInt(telaPedidoPeca.getTxtQuantidadeSaida().getText());
        String colaboradorPedido = Utils.colaboradorLogado;
        String statusPeca = "PENDENTE";
        
        Orcamento orcamento = new Orcamento(partNumber, nomePeca, quantidade, colaboradorPedido, motivo, etapa, sessao, chassis, eixoLado, numeroMotorCambio, statusPeca);
        
        return orcamento;
        
    }
    
    public void registrarOrcamento() {
        conexao = ModuloConexao.conector();
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);
        
        if (Utils.linhaSelecionadaContemDados(telaPedidoPeca.getTblSolicitarPecas())) {
            
            orcamentoDAO.inserirOrcamento(setaOrcamentoAtravesDeCamposPreenchidos());
            limpaBusca();
            atualizaTabelaPecasPedidasPorChassisEEtapa();
            
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha com dados para registrar a saída de uma peça");
        }
    }
    
    
    
    public void atualizaTabelaPecasPedidasPorChassisEEtapa() {
        conexao = ModuloConexao.conector();
        ResultSet rs;
        
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);
        String chassis = telaPedidoPeca.getCbChassis().getSelectedItem().toString();
        String etapa = telaPedidoPeca.getCbEtapa().getSelectedItem().toString();
        
        rs = orcamentoDAO.procurarPecaPorChassisEEtapa(chassis, etapa);
        
        if (rs != null) {
            telaPedidoPeca.getTblPecasPedidas().setModel(DbUtils.resultSetToTableModel(rs));
            Utils.ajustarLarguraColunas(telaPedidoPeca.getTblPecasPedidas());
        }
        
    }
    
    public void cancelarPecaSolicitada() {
        
        if (Utils.linhaSelecionadaContemDados(telaPedidoPeca.getTblPecasPedidas())) {
            conexao = ModuloConexao.conector();
            int linhaSelecionada = telaPedidoPeca.getTblPecasPedidas().getSelectedRow();
            String status = telaPedidoPeca.getTblPecasPedidas().getModel().getValueAt(linhaSelecionada, 5).toString();
            
            if (status.equals("PENDENTE") || status.equals("SEPARADA")) {
                int id = Integer.parseInt(telaPedidoPeca.getTblPecasPedidas().getModel().getValueAt(linhaSelecionada, 0).toString());
                OrcamentoDAO orcamentoDao = new OrcamentoDAO(conexao);
                orcamentoDao.atualizarStatusPecaSolicitada(id, "CANCELADA");
                atualizaTabelaPecasPedidasPorChassisEEtapa();
                
            } else {
                JOptionPane.showMessageDialog(null, "só é possivel cancelar o status da peça se estiver pedida ou separada");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário que a linha selecionada contenha dados para prosseguir");
        }

        
    }
    
    public void limpaBusca(){
    
    telaPedidoPeca.getTxtLPesquisar().setText(null);
    telaPedidoPeca.getTxtQuantidadeSaida().setText(null);
    telaPedidoPeca.getCbLado().setSelectedIndex(0);
     DefaultTableModel tabela = (DefaultTableModel) telaPedidoPeca.getTblSolicitarPecas().getModel();
     tabela.setRowCount(0);
    
    
    }
    
    public void setarEdicaoCabecalio (){
        telaPedidoPeca.getCbChassis().setEnabled(false);
        telaPedidoPeca.getCbEtapa().setEnabled(false);
        telaPedidoPeca.getCbSessao().setEnabled(false);
        
    }
    
}
