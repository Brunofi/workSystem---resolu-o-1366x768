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
        String sql = "insert into tbusuarios (locacao,sub) values(?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, locacao.getLocacao());
            pst.setString(2, locacao.getSub());
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

}
