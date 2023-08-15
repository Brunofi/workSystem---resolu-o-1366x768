/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Peca;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class PecaDAO {
    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public PecaDAO(Connection conexao) {
        this.conexao = conexao;

    }
    
    public void inserirPeca (Peca peca){
        String sql = "insert into tbpecas (nome,partnumber,peso,ncm,estado,modelocarro,subsistema,"
                + "fabricante,qtdmin,qtdmed,qtdmax,preco,ptnumber_similar) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,peca.getNome());
            pst.setString(2,peca.getPartNumber());
            pst.setString(3,peca.getPeso());
            pst.setString(4,peca.getNcm());
            pst.setString(5,peca.getEstado());
            pst.setString(6,peca.getModeloCarro());
            pst.setString(7,peca.getSubSistema());
            pst.setString(8,peca.getFabricante());
            pst.setInt(9,peca.getQtdMin());
            pst.setInt(10,peca.getQtdMed());
            pst.setInt(11,peca.getQtdMax());
            pst.setBigDecimal(12, peca.getPreco());
            pst.setString(13,peca.getPartNumberSimilar());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    public void alterarPeca(Peca peca){
        String sql = "update tbpecas set nome=?, partnumber=?, peso=?, ncm=?,"
                + " estado=?, modelocarro=?, subsistema=?, fabricante=?, qtdmin=?,"
                + " qtdmed=?, qtdmax=?, preco=?, ptnumber_similar=? where id=?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,peca.getNome());
            pst.setString(2,peca.getPartNumber());
            pst.setString(3,peca.getPeso());
            pst.setString(4,peca.getNcm());
            pst.setString(5,peca.getEstado());
            pst.setString(6,peca.getModeloCarro());
            pst.setString(7,peca.getSubSistema());
            pst.setString(8,peca.getFabricante());
            pst.setInt(9,peca.getQtdMin());
            pst.setInt(10,peca.getQtdMed());
            pst.setInt(11,peca.getQtdMax());
            pst.setBigDecimal(12, peca.getPreco());
            pst.setString(13,peca.getPartNumberSimilar());
            pst.setInt(14, peca.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peca alterada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    public ResultSet pesquisarPorPartNumber(Peca peca){
        String sql = "select * from tbpecas where partnumber like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, peca.getPartNumber() + "%");
            rs = pst.executeQuery();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    
    }
    
    public ResultSet pesquisarPorNome(Peca peca){
        String sql = "select * from tbpecas where nome like ?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, peca.getPartNumber() + "%");
            rs = pst.executeQuery();
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    
    }
    
    
}
