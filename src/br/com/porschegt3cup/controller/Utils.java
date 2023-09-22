/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import javax.swing.JTable;

/**
 *
 * @author Bruno
 */
public class Utils {
   static String colaboradorLogado=TelaLoginController.colaborador;
    
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
    
}
