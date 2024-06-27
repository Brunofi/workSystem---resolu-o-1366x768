/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Orcamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class OrcamentoDAO {

    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public OrcamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirOrcamento(Orcamento orcamento) {
        String sql = "INSERT INTO tborcamentos (partnumber, nome_peca, quantidade, colaborador_pedido, motivo_consumo, etapa, sessao, chassis, eixo_lado, numero_motor_cambio,status_peca) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, orcamento.getPartNumber());
            pst.setString(2, orcamento.getNomePeca());
            pst.setInt(3, orcamento.getQuantidade());
            pst.setString(4, orcamento.getColaboradorPedido());
            pst.setString(5, orcamento.getMotivoConsumo());
            pst.setString(6, orcamento.getEtapa());
            pst.setString(7, orcamento.getSessao());
            pst.setString(8, orcamento.getChassis());
            pst.setString(9, orcamento.getEixoLado());
            pst.setString(10, orcamento.getNumeroMotorCambio());
            pst.setString(11, orcamento.getStatusPeca());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peça solicitada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public ResultSet procurarPecaPorChassisEEtapa(String chassis, String etapa) {
    String sql = "SELECT\n"
                + "tborcamentos.id AS `ID`,\n"
                + "tborcamentos.partnumber AS `Part Number`,\n"
                + "tborcamentos.nome_peca AS `Descricao`,\n"
                + "tborcamentos.quantidade AS `Quantidade`,\n"
                + "tborcamentos.motivo_consumo AS `Motivo`,\n"
                + "tborcamentos.status_peca AS `Status`\n"
                + "FROM\n"
                + "tborcamentos\n"
                + "WHERE\n"
                + "etapa = ? AND chassis = ?";

    ResultSet rs = null; // Declaração do ResultSet localmente

    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, etapa); // Corrigido a ordem dos parâmetros
        pst.setString(2, chassis);
        rs = pst.executeQuery();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

    return rs;
}
    
    public void atualizarStatusPecaSolicitada(int id,String status){
        String sql = "update tborcamentos set status_peca=? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, status);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "status da peca atualizada com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    }
    
        
    


}
