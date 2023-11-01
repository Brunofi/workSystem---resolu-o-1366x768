/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.view.TelaInventario;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bruno
 */
public class TelaInventarioController {

    private TelaInventario telaInventario;
    Connection conexao = null;

    public TelaInventarioController(TelaInventario telaInventario) {
        this.telaInventario = telaInventario;
    }

    public void carregarLocacoes() {
        conexao = ModuloConexao.conector();
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        Set<String> listaLocacoes = locacaoDao.buscaListaLocacoes();
        telaInventario.getCbLocacao().addItem("");
        for (String locacao : listaLocacoes) {
            telaInventario.getCbLocacao().addItem(locacao);
        }
    }

    public void obterPecasNaTabelaDeInventario() {
        conexao = ModuloConexao.conector();
        String locacao = telaInventario.getCbLocacao().getSelectedItem().toString();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs = estoqueDao.procurarPecaEstoquePorLocacao(locacao);

        if (rs != null) {
            try {
                // Obtém o modelo da tabela
                DefaultTableModel model = (DefaultTableModel) telaInventario.getTblInventario().getModel();

                // Limpa as linhas existentes, se houver
                model.setRowCount(0);

                // Adiciona as linhas do ResultSet ao modelo
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("ID"),
                        rs.getString("PART NUMBER"),
                        rs.getString("DESCRIÇÂO"),
                        rs.getString("LOCAÇÂO"),
                        rs.getString("SUB LOCAÇÂO"),
                        "" // Adicione uma coluna vazia editável
                    };
                    model.addRow(row);
                }

                // Define um editor de células para as cinco primeiras colunas
                for (int i = 0; i < 5; i++) {
                    TableColumn column = telaInventario.getTblInventario().getColumnModel().getColumn(i);
                    column.setCellEditor(new DefaultCellEditor(new JTextField()));
                    column.setCellRenderer(new DefaultTableCellRenderer() {
                        @Override
                        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                            c.setEnabled(false);
                            return c;
                        }
                    });
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e.getMessage());
            }
        }
    }

}
