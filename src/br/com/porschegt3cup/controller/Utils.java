/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bruno
 */
public class Utils {

    static String colaboradorLogado = TelaLoginController.colaborador;

    public static boolean linhaSelecionadaContemDados(JTable tabela) {
        int linhaSelecionada = tabela.getSelectedRow();
        if (linhaSelecionada != -1) {
            for (int coluna = 0; coluna < tabela.getColumnCount(); coluna++) {
                Object valor = tabela.getValueAt(linhaSelecionada, coluna);
                if (valor != null && !valor.toString().isEmpty()) {
                    return true; // A linha contém dados
                }
            }
        }
        return false; // A linha está vazia ou não selecionada
    }
    
    public static void ajustarLarguraColunas(JTable tabela) {
    for (int i = 0; i < tabela.getColumnCount(); i++) {
        TableColumn coluna = tabela.getColumnModel().getColumn(i);
        int largura = 15; // Define uma largura mínima
        
        for (int j = 0; j < tabela.getRowCount(); j++) {
            TableCellRenderer renderizador = tabela.getCellRenderer(j, i);
            Component componente = tabela.prepareRenderer(renderizador, j, i);
            largura = Math.max(componente.getPreferredSize().width + 1, largura);
        }
        
        coluna.setPreferredWidth(largura);
    }
}
    
    public static void tornarColunasNaoEditaveis(JTable tabela, int numColunasNaoEditaveis) {
    for (int i = 0; i < numColunasNaoEditaveis; i++) {
        TableColumn coluna = tabela.getColumnModel().getColumn(i);
        coluna.setCellEditor(new NonEditableCellEditor());
    }
}
    
    public static void permitirSelecaoApenasUmaLinha(JTable tabela) {
    tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}
    
    public static boolean tabelaEstaPreenchida(JTable tabela) {
    DefaultTableModel model = (DefaultTableModel) tabela.getModel();
    int rowCount = model.getRowCount();
    int columnCount = model.getColumnCount();

    for (int row = 0; row < rowCount; row++) {
        for (int col = 0; col < columnCount; col++) {
            Object value = model.getValueAt(row, col);
            if (value != null && !value.toString().isEmpty()) {
                return true;
            }
        }
    }

    return false;
}



}


