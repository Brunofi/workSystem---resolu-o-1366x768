/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;
import br.com.porschegt3cup.model.Inventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class InventarioDao {
    
    
    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public InventarioDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirDadosNoInventario(List<Inventario> dados) {
       
        String sql = "insert into tbcontrole_inventario(idestoque,quantidade_velha,quantidade_atual,nome_colaborador) values (?,?,?,?)";
        
        try {
            pst = conexao.prepareStatement(sql);
            for (Inventario dado : dados) {
                pst.setInt(1, dado.getIdEstoque());
                pst.setInt(2, dado.getQuantidadeVelha());
                pst.setInt(3, dado.getQuantidadeAtual());
                pst.setString(4, dado.getNomeColaborador());
                pst.addBatch(); // Adiciona a operação ao lote
            }

            pst.executeBatch(); // Executa todas as operações em lote
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
    
    
    
    
}
