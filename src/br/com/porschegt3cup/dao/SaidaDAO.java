/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Saida;
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

    public void registrarDadosDeSaidaNoEstoque(Saida saida) {
        String sql = "insert into tbsaida(quantidade,tipo_consumo,colaborador_entrega,colaborador_retirada,colaborador_lancamento,motivo_consumo,etapa,sessao,chassis,chassis_cedente,eixo_lado,idpeca,idlocacao)values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, saida.getQuantidadeSaida());
            pst.setString(2, saida.getTipoMovimentacao());
            pst.setString(3, saida.getColaboradorEntrega());
            pst.setString(4, saida.getColaboradorRetira());
            pst.setString(5, saida.getColaboradorLanca());
            pst.setString(6, saida.getMotivoConsumo());
            pst.setString(7, saida.getEtapa());
            pst.setString(8, saida.getSessao());
            pst.setString(9, saida.getChassis());
            pst.setString(10, saida.getChassisCedente());
            pst.setString(11, saida.getEixoLado());
            pst.setInt(12, saida.getIdPeca());
            pst.setInt(13, saida.getIdLocacao());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de saída de peça realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
