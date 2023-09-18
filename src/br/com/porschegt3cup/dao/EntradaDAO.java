/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Entrada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class EntradaDAO {
    
    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public EntradaDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void registrarDadosDeEntradaNoEstoque(Entrada entrada){
    String sql = "insert into tbentrada(quantidade_entrada,motivo,colaborador,observacao,idpeca,idlocacao)values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, entrada.getQuantidadeEntrada());
            pst.setString(2, entrada.getMotivo());
            pst.setString(3, entrada.getColaborador());
            pst.setString(4, entrada.getObservacao());
            pst.setInt(5, entrada.getIdPeca());
            pst.setInt(6, entrada.getIdLocacao());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de peça realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    
    
}
