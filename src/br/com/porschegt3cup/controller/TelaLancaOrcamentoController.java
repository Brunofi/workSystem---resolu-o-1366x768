/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.OrcamentoDAO;
import br.com.porschegt3cup.dao.RecuperacaoPecaControleDAO;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.model.Estoque;
import br.com.porschegt3cup.model.Orcamento;
import br.com.porschegt3cup.model.PecaRecuperacao;
import br.com.porschegt3cup.model.Saida;

import br.com.porschegt3cup.view.TelaLancaOrcamento;
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
public class TelaLancaOrcamentoController {

    private TelaLancaOrcamento telaLancaOrcamento;
    Connection conexao = null;
    Orcamento orcamento = null;
    Estoque estoque = null;
    Saida saida = null;

    public TelaLancaOrcamentoController(TelaLancaOrcamento telaLancaOrcamento) {
        this.telaLancaOrcamento = telaLancaOrcamento;
    }

    public void carregarListaDeChassisSaida() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        telaLancaOrcamento.getCbChassis().addItem("");
        for (String chassis : listaChassis) {
            telaLancaOrcamento.getCbChassis().addItem(chassis);
        }
    }

    public List<String> carregarChassis() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        return saidaDao.buscarListaDeChassis();
    }

    public void carregarListaDeEtapas() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaEtapas = saidaDao.buscarListaDeEtapas();
        telaLancaOrcamento.getCbEtapa().addItem("");
        for (String etapa : listaEtapas) {
            telaLancaOrcamento.getCbEtapa().addItem(etapa);
        }
    }

    public void visualizarPecasEntregues() {
        conexao = ModuloConexao.conector();
        String chassis = telaLancaOrcamento.getCbChassis().getSelectedItem().toString();
        String etapa = telaLancaOrcamento.getCbEtapa().getSelectedItem().toString();
        String status = "ENTREGUE";
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);
        ResultSet rs = orcamentoDAO.procuraPecasEntregues(chassis, etapa, status);

        if (rs != null) {
            telaLancaOrcamento.getTblPecasEntregues().setModel(DbUtils.resultSetToTableModel(rs));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma peça entregue encontrada.");
        }
    }

    public void buscaPecaNoEstoque() {
        if (Utils.linhaSelecionadaContemDados(telaLancaOrcamento.getTblPecasEntregues())) {
            conexao = ModuloConexao.conector();
            EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
            ResultSet rs;
            int linhaSelecionada = telaLancaOrcamento.getTblPecasEntregues().getSelectedRow();
            String partNumber = telaLancaOrcamento.getTblPecasEntregues().getModel().getValueAt(linhaSelecionada, 1).toString();
            rs = estoqueDao.procurarPecaEstoquePorPartNumber(partNumber);

            if (rs != null) {
                telaLancaOrcamento.getTblSaida().setModel(DbUtils.resultSetToTableModel(rs));
                Utils.ajustarLarguraColunas(telaLancaOrcamento.getTblSaida());

            } else {

                JOptionPane.showMessageDialog(null, "Peça não tem cadastro no estoque.");
            }

        } else {

            JOptionPane.showMessageDialog(null, "É preciso selecionar uma peça para fazer a busca no estoque.");
        }

    }

    public void registrarSaida() {
        conexao = ModuloConexao.conector();
        if (Utils.linhaSelecionadaContemDados(telaLancaOrcamento.getTblSaida()) && Utils.linhaSelecionadaContemDados(telaLancaOrcamento.getTblPecasEntregues())) {
            int linhaSelecionada = telaLancaOrcamento.getTblPecasEntregues().getSelectedRow();
            int id = Integer.parseInt(telaLancaOrcamento.getTblPecasEntregues().getValueAt(linhaSelecionada, 0).toString());
            Orcamento orcamento = new Orcamento();
            orcamento = buscaObjetoNoBancoDeDados(id);
            this.orcamento = orcamento;

            if (this.orcamento.getStatusPeca().equalsIgnoreCase("ENTREGUE")) {

                coletaDadosEstoque();
                coletaDadosSaida();

                //Baixa no estoque
                EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
                estoqueDao.subtrairQuantidadePecaNoEstoque(estoque.getId(), estoque.getQuantidade());

                //Registra a Saida na tabela do banco de dados
                SaidaDAO saidaDao = new SaidaDAO(conexao);
                int idRegistroSaida = saidaDao.registrarDadosDeSaidaNoEstoque(saida, estoque);
                registrarPecaTabelaDeRecuperacao(idRegistroSaida);

                //altera status da peça orçada para lançada
                OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);
                orcamentoDAO.atualizarStatusPecaSolicitada(id, "LANCADA");

                apagarDadosTabelaLancamento();
                visualizarPecasEntregues();

            } else {
                JOptionPane.showMessageDialog(null, "Para lançar uma peça é necessario seu Status estar como 'ENTREGUE' ");

            }

        } else {
            JOptionPane.showMessageDialog(null, "É selecionar linha de ambas as tabelas para lançar a peça");
        }

    }

    public void apagarDadosTabelaLancamento() {

        DefaultTableModel tabela = (DefaultTableModel) telaLancaOrcamento.getTblSaida().getModel();
        tabela.setRowCount(0);
    }

    public void registrarPecaTabelaDeRecuperacao(int idRegistroSaida) {
        conexao = ModuloConexao.conector();
        RecuperacaoPecaControleDAO recuperacaoPecaControleDAO = new RecuperacaoPecaControleDAO(conexao);
        PecaRecuperacao pecaRecuperacao = new PecaRecuperacao(idRegistroSaida, "EM ANALISE", "ESTOQUE");
        recuperacaoPecaControleDAO.inserirPecaRecuperacao(pecaRecuperacao);
    }

    public Orcamento buscaObjetoNoBancoDeDados(int id) {
        conexao = ModuloConexao.conector();
        OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);
        return orcamentoDAO.retornaObjetoOrcamento(id);
    }

    public void coletaDadosSaida() {
        this.saida = new Saida();

        int linhaSelecionada = telaLancaOrcamento.getTblSaida().getSelectedRow();
        int idPeca = Integer.parseInt(telaLancaOrcamento.getTblSaida().getValueAt(linhaSelecionada, 7).toString());
        int idLocacao = Integer.parseInt(telaLancaOrcamento.getTblSaida().getValueAt(linhaSelecionada, 8).toString());

        saida.setQuantidadeSaida(orcamento.getQuantidade());
        saida.setTipoMovimentacao("CONSUMO");
        saida.setColaboradorEntrega(orcamento.getColaboradorEntrega());
        saida.setColaboradorRetira(orcamento.getColaboradorPedido());
        saida.setColaboradorLanca(Utils.colaboradorLogado);
        saida.setMotivoConsumo(orcamento.getMotivoConsumo());
        saida.setEtapa(orcamento.getEtapa());
        saida.setSessao(orcamento.getSessao());
        saida.setChassis(orcamento.getChassis());
        saida.setChassisCedente("-");
        saida.setEixoLado(orcamento.getEixoLado());
        saida.setIdPeca(idPeca);
        saida.setIdLocacao(idLocacao);

    }

    public void coletaDadosEstoque() {
        this.estoque = null;
        int linhaSelecionadaTblSaida = telaLancaOrcamento.getTblSaida().getSelectedRow();
        int linhaSelecionadaTblPecaEntregue = telaLancaOrcamento.getTblPecasEntregues().getSelectedRow();

        int idEstoque = Integer.parseInt(telaLancaOrcamento.getTblSaida().getValueAt(linhaSelecionadaTblSaida, 6).toString());
        int idPeca = Integer.parseInt(telaLancaOrcamento.getTblSaida().getValueAt(linhaSelecionadaTblSaida, 7).toString());
        int idLocacao = Integer.parseInt(telaLancaOrcamento.getTblSaida().getValueAt(linhaSelecionadaTblSaida, 8).toString());
        int quantidade = Integer.parseInt(telaLancaOrcamento.getTblPecasEntregues().getValueAt(linhaSelecionadaTblPecaEntregue, 3).toString());

        this.estoque = new Estoque(idEstoque, quantidade, idPeca, idLocacao);

    }

}
