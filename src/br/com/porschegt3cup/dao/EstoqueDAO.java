/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class EstoqueDAO {
    
    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public EstoqueDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void inserirEstoque(int quantidade, int idPeca, int IdLocacao){
        
        String sql = "insert into tbestoque (quantidade,idpeca,idlocacao) values (?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, quantidade);
            pst.setInt(2, idPeca);
            pst.setInt(3, IdLocacao);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Estoque cadastrada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
