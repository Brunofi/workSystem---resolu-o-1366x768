/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class PecaSolicitadaTableModel extends AbstractTableModel {
    private final String[] colunas = {"ID", "Part Number", "Descricao", "Qtd Pedida", "Motivo", "Chassis", "Status", "Qtd Estoque", "Locação"};
    private ArrayList<Orcamento> listaPecas;

    public PecaSolicitadaTableModel(ArrayList<Orcamento> listaPecas) {
        this.listaPecas = listaPecas;
    }

    @Override
    public int getRowCount() {
        return listaPecas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orcamento orcamento = listaPecas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return orcamento.getId();
            case 1:
                return orcamento.getPartNumber();
            case 2:
                return orcamento.getNomePeca();
            case 3:
                return orcamento.getQuantidade();
            case 4:
                return orcamento.getMotivoConsumo();
            case 5:
                return orcamento.getChassis();
            case 6:
                return orcamento.getStatusPeca();
            case 7:
                return orcamento.getQuantidadeEstoque();
            case 8:
                return orcamento.getLocacoes(); // Locação vazia
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    public void ajustarLarguraColunas(JTable table) {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);   // ID
        columnModel.getColumn(1).setPreferredWidth(150);  // Part Number
        columnModel.getColumn(2).setPreferredWidth(350);  // Descricao
        columnModel.getColumn(3).setPreferredWidth(100);  // Qtd Pedida
        columnModel.getColumn(4).setPreferredWidth(100);  // Motivo
        columnModel.getColumn(5).setPreferredWidth(100);  // Chassis
        columnModel.getColumn(6).setPreferredWidth(100);  // Status
        columnModel.getColumn(7).setPreferredWidth(100);  // Qtd Estoque
        columnModel.getColumn(8).setPreferredWidth(250);  // Locação
    }
}
