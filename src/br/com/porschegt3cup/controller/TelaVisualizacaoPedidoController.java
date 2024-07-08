/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.OrcamentoDAO;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.model.Orcamento;
import br.com.porschegt3cup.model.PecaSolicitadaTableModel;
import br.com.porschegt3cup.view.TelaVisualizacaoPedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Bruno
 */
public class TelaVisualizacaoPedidoController {
    
    private TelaVisualizacaoPedido telaVisualizacaoPedido;
    Connection conexao = null;

    public TelaVisualizacaoPedidoController(TelaVisualizacaoPedido telaVisualizacaoPedido) {
        this.telaVisualizacaoPedido = telaVisualizacaoPedido;
    }
    
     public void carregarListaDeChassisSaida() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        telaVisualizacaoPedido.getCbChassis().addItem("");
        for (String chassis : listaChassis) {
            telaVisualizacaoPedido.getCbChassis().addItem(chassis);
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
        telaVisualizacaoPedido.getCbEtapa().addItem("");
        for (String etapa : listaEtapas) {
            telaVisualizacaoPedido.getCbEtapa().addItem(etapa);
        }
    }
    
    
    public void carregarListaDeSessoes() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaSessoes = saidaDao.buscarListaDeSessoes();
        telaVisualizacaoPedido.getCbSessao().addItem("");
        for (String sessao : listaSessoes) {
            telaVisualizacaoPedido.getCbSessao().addItem(sessao);
        }
    }
    
    public void carregarListaStatusPesqusisa(){
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("PENDENTE");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("SEPARADO");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("ENTREGUE");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("INDISPONIVEL");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("CANCELADA");
        telaVisualizacaoPedido.getCbStatusPesquisa().addItem("SOLUCIONADO INTERNO");
       
        
        
    }
    
    public void carregarListaStatusAlterado(){
    telaVisualizacaoPedido.getCbStatusAlterado().addItem("SEPARADO");
    telaVisualizacaoPedido.getCbStatusAlterado().addItem("ENTREGUE");
    telaVisualizacaoPedido.getCbStatusAlterado().addItem("INDISPONIVEL");
    telaVisualizacaoPedido.getCbStatusAlterado().addItem("CANCELADA");
    telaVisualizacaoPedido.getCbStatusAlterado().addItem("SOLUCIONADO INTERNO");
        
    }
    
    public void carregarListaEstadoPeca(){
    telaVisualizacaoPedido.getCbEstadoPeca().addItem("");
    telaVisualizacaoPedido.getCbEstadoPeca().addItem("NOVA");
    telaVisualizacaoPedido.getCbEstadoPeca().addItem("REC");
    telaVisualizacaoPedido.getCbEstadoPeca().addItem("FN");
        
    }
   
    public void visualizarPecasPedidas() {
    conexao = ModuloConexao.conector();
    String chassis = telaVisualizacaoPedido.getCbChassis().getSelectedItem().toString();
    String etapa = telaVisualizacaoPedido.getCbEtapa().getSelectedItem().toString();
    String sessao = telaVisualizacaoPedido.getCbSessao().getSelectedItem().toString();
    String status = telaVisualizacaoPedido.getCbStatusPesquisa().getSelectedItem().toString();

    OrcamentoDAO orcamentoDAO = new OrcamentoDAO(conexao);

    // Cria um mapa para armazenar os filtros e seus valores
    Map<String, String> filtros = new HashMap<>();
    if (!chassis.isEmpty()) filtros.put("chassis", chassis);
    if (!etapa.isEmpty()) filtros.put("etapa", etapa);
    if (!sessao.isEmpty()) filtros.put("sessao", sessao);
    if (!status.isEmpty()) filtros.put("status_peca", status);

    // Chama o método DAO com os filtros
    ArrayList<Orcamento> listaPecas = orcamentoDAO.procurarPecasSolicitadas(filtros);
    PecaSolicitadaTableModel tableModel = new PecaSolicitadaTableModel(listaPecas);

    // Associa o modelo de tabela ao JTable
    telaVisualizacaoPedido.getTblPecasPedidas().setModel(tableModel);
    
    // Ajusta a largura das colunas
    tableModel.ajustarLarguraColunas(telaVisualizacaoPedido.getTblPecasPedidas());
}
    
    public void alteraStatusIncluiEstadoDaPeca(){
    
        if (Utils.linhaSelecionadaContemDados(telaVisualizacaoPedido.getTblPecasPedidas())) {
            int linhaSelecionada = telaVisualizacaoPedido.getTblPecasPedidas().getSelectedRow();
            String statusAlterado = telaVisualizacaoPedido.getCbStatusAlterado().getSelectedItem().toString();
            String estadoPeca = telaVisualizacaoPedido.getCbEstadoPeca().getSelectedItem().toString();
            int id = Integer.parseInt(telaVisualizacaoPedido.getTblPecasPedidas().getModel().getValueAt(linhaSelecionada, 0).toString());
            OrcamentoDAO orcamentoDao = new OrcamentoDAO(conexao);
            orcamentoDao.atualizaStatusPecaEEstadoPeca(id, statusAlterado, estadoPeca);
            visualizarPecasPedidas();
        } else {
            JOptionPane.showMessageDialog(null, "É necessário que a linha selecionada contenha dados para prosseguir");
        }
    
    
    }
    
    public void alteraStatusPeca(){
    
        if (Utils.linhaSelecionadaContemDados(telaVisualizacaoPedido.getTblPecasPedidas())) {
            int linhaSelecionada = telaVisualizacaoPedido.getTblPecasPedidas().getSelectedRow();
            String statusAlterado = telaVisualizacaoPedido.getCbStatusAlterado().getSelectedItem().toString();
            int id = Integer.parseInt(telaVisualizacaoPedido.getTblPecasPedidas().getModel().getValueAt(linhaSelecionada, 0).toString());
            OrcamentoDAO orcamentoDao = new OrcamentoDAO(conexao);
            orcamentoDao.atualizarStatusPecaSolicitada(id, statusAlterado);
            visualizarPecasPedidas();
            
        } else {
            JOptionPane.showMessageDialog(null, "É necessário que a linha selecionada contenha dados para prosseguir");
        }
    
    
    }

    
    
}
