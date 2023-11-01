/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Locacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class LocacaoDAO {

    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public LocacaoDAO(Connection conexao) {
        this.conexao = conexao;

    }

    public void inserirLocacao(Locacao locacao) {
        String sql = "insert into tblocacoes (locacao,sub) values(?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, locacao.getLocacao());
            pst.setString(2, locacao.getSub());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Locação cadastrada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public ResultSet pesquisarLocacao(Locacao locacao) {
        String sql = "select id as ID,locacao as LOCAÇÃO, sub as `SUB LOCAÇÃO` from  tblocacoes where locacao like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, locacao.getLocacao() + "%");
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Locação não encontrada");
                return null;
            }

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return null;

    }

    public void alterarLocacao(Locacao locacao) {
        String sql = "update tblocacoes set locacao=?,sub=? where id=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, locacao.getLocacao());
            pst.setString(2, locacao.getSub());
            pst.setInt(3, locacao.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Locacao alterada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void removerLocacao(Locacao locacao) {
        String sql = "delete from tblocacoes where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, locacao.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Locacao removida com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public Set<String> buscaListaLocacoes() {
        Set<String> listaLocacoes = new TreeSet<>();
        String sql = "select * from tblocacoes";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String locacao = rs.getString("locacao");
                listaLocacoes.add(locacao);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaLocacoes;
    }

}
