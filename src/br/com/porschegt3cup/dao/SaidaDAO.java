/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class SaidaDAO {

    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SaidaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<String> buscarListaDeColaboradores() {
        List<String> nomesColaboradores = new ArrayList<>();
        String sql = "select * from colaboradores";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String nomeColaborador = rs.getString("nome");
                nomesColaboradores.add(nomeColaborador);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return nomesColaboradores;

    }

    public List<String> buscarListaDeChassis() {
        List<String> listaChassis = new ArrayList<>();
        String sql = "select * from chassis";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String chassis = rs.getString("numeral");
                listaChassis.add(chassis);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return listaChassis;

    }

    public List<String> buscarListaDeSessoes() {
        List<String> listaSessoes = new ArrayList<>();
        String sql = "select * from sessoes";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String sessao = rs.getString("sessao");
                listaSessoes.add(sessao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaSessoes;
    }

    public List<String> buscarListaDeEtapas() {
        List<String> listaEtapas = new ArrayList<>();
        String sql = "select * from etapas";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String etapa = rs.getString("etapa");
                listaEtapas.add(etapa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaEtapas;
    }
    
    

}
