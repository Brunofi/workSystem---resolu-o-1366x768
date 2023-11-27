/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.PecaRecuperacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class RecuperacaoPecaControleDAO {
    
    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public RecuperacaoPecaControleDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    /*String sql = "insert into tbusuarios (nome,login,senha,perfil) values(?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getPerfil());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    */
    
    public void inserirPecaRecuperacao(PecaRecuperacao pecaRecuperacao ){
        
        String sql = "insert into tbcontrole_recuperacao_pecas (idsaida_estoque,situacao,setor) values (?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, pecaRecuperacao.getIdSaidaEstoque());
            pst.setString(2, pecaRecuperacao.getSituacao());
            pst.setString(3, pecaRecuperacao.getSetor());
            pst.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

}
    
}
