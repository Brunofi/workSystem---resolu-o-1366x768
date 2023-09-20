/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.model.Estoque;
import br.com.porschegt3cup.model.Saida;
import br.com.porschegt3cup.view.TelaSaidaPeca;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaSaidaPecaController {

    private TelaSaidaPeca telaSaidaPeca;
    Connection conexao = null;
    String colaboradorlancamento;
    Estoque estoque = null;
    Saida saida = null;

    public TelaSaidaPecaController(TelaSaidaPeca telaSaidaPeca) {
        this.telaSaidaPeca = telaSaidaPeca;
    }
    
    public void apagarCampos(){
        telaSaidaPeca.getCbLado().setSelectedIndex(0);
        telaSaidaPeca.getTxtQuantidadeSaida().setText(null);
        telaSaidaPeca.getCbMotivo().setSelectedIndex(0);
    
    }

    public void carregarListaDeColaboradores() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> nomesColaboradores = saidaDao.buscarListaDeColaboradores();
        telaSaidaPeca.getCbColaboradorEntrega().addItem("");
        telaSaidaPeca.getCbColaboradorRetira().addItem("");
        for (String nome : nomesColaboradores) {
            telaSaidaPeca.getCbColaboradorEntrega().addItem(nome);
            telaSaidaPeca.getCbColaboradorRetira().addItem(nome);
        }
    }

    public void carregarListaDeChassisSaida() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        telaSaidaPeca.getCbChassis().addItem("");
        for (String chassis : listaChassis) {
            telaSaidaPeca.getCbChassis().addItem(chassis);
        }
    }

    public void carregarListaDeChassisCedente() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        for (String chassis : listaChassis) {
            telaSaidaPeca.getCbChassisCedente().addItem(chassis);
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
        telaSaidaPeca.getCbSessao().addItem("");
        for (String sessao : listaSessoes) {
            telaSaidaPeca.getCbSessao().addItem(sessao);
        }
    }

    public void carregarListaDeEtapas() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaEtapas = saidaDao.buscarListaDeEtapas();
        telaSaidaPeca.getCbEtapa().addItem("");
        for (String etapa : listaEtapas) {
            telaSaidaPeca.getCbEtapa().addItem(etapa);
        }
    }

    public void procuraPecaNoEstoque() {
        conexao = ModuloConexao.conector();
        String peca = telaSaidaPeca.getTxtLPesquisar().getText();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs;

        if (telaSaidaPeca.getrBtnPartNumber().isSelected()) {
            rs = estoqueDao.procurarPecaEstoquePorPartNumber(peca);
        } else {
            rs = estoqueDao.procurarPecaEstoquePorDescricao(peca);
        }

        if (rs != null) {
            telaSaidaPeca.getTblSaidaPeca().setModel(DbUtils.resultSetToTableModel(rs));
        }

    }

    public void descobreColaborador() {
        colaboradorlancamento = TelaLoginController.colaborador;
        //System.out.println(colaboradorlancamento);

    }

    public void coletaDadosPreencheVariaveis() {
        colaboradorlancamento = TelaLoginController.colaborador;
        int linhaSelecionada = telaSaidaPeca.getTblSaidaPeca().getSelectedRow();
        String tipoMovimentacao = telaSaidaPeca.getCbTipo().getSelectedItem().toString();
        String chassis = telaSaidaPeca.getCbChassis().getSelectedItem().toString();
        String etapa = telaSaidaPeca.getCbEtapa().getSelectedItem().toString();
        String chassisCedente;
        if (telaSaidaPeca.getCbChassisCedente().getSelectedItem()==null) {
            chassisCedente = "-";
        } else{
            chassisCedente = telaSaidaPeca.getCbChassisCedente().getSelectedItem().toString();
        }
        String lado = telaSaidaPeca.getCbLado().getSelectedItem().toString();
        int quantidadeSaida = Integer.parseInt(telaSaidaPeca.getTxtQuantidadeSaida().getText());
        String sessao = telaSaidaPeca.getCbSessao().getSelectedItem().toString();
        String motivo = telaSaidaPeca.getCbMotivo().getSelectedItem().toString();
        String colaboradorEntrega = telaSaidaPeca.getCbColaboradorEntrega().getSelectedItem().toString();
        String colaboradorRetira = telaSaidaPeca.getCbColaboradorRetira().getSelectedItem().toString();
        int quantidadeEstoque = Integer.parseInt(telaSaidaPeca.getTblSaidaPeca().getModel().getValueAt(linhaSelecionada, 2).toString());
        int idEstoque = Integer.parseInt(telaSaidaPeca.getTblSaidaPeca().getModel().getValueAt(linhaSelecionada, 5).toString());
        int idPeca = Integer.parseInt(telaSaidaPeca.getTblSaidaPeca().getModel().getValueAt(linhaSelecionada, 6).toString());
        int idlocacao = Integer.parseInt(telaSaidaPeca.getTblSaidaPeca().getModel().getValueAt(linhaSelecionada, 7).toString());
        int quantidadeSubtraida = quantidadeEstoque - quantidadeSaida;
        //System.out.println(quantidadeSomada);
        Saida saida = new Saida(quantidadeSaida, tipoMovimentacao, colaboradorEntrega, colaboradorRetira, colaboradorlancamento, motivo, etapa, sessao, chassis, chassisCedente, lado, idPeca, idlocacao);
        Estoque estoque = new Estoque(idEstoque, quantidadeSubtraida);
        this.saida = saida;
        this.estoque = estoque;

    }
    
    public void registrarSaida(){
        conexao = ModuloConexao.conector();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        int linhaSelecionada = telaSaidaPeca.getTblSaidaPeca().getSelectedRow();
        
        if (linhaSelecionada != -1) {
            coletaDadosPreencheVariaveis();
            estoqueDao.alterarQuantidadePecaNoEstoque(estoque.getId(), estoque.getQuantidade());
           //System.out.println(estoque.toString());
            saidaDao.registrarDadosDeSaidaNoEstoque(saida);
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessario selecionar uma linha para registrar a entrada de uma peça ");

        }
    
    }

}
