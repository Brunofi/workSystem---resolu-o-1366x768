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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        String sql = "INSERT INTO tborcamentos (partnumber, nome_peca, quantidade, colaborador_pedido, motivo_consumo, etapa, sessao, chassis, eixo_lado, numero_motor_cambio,status_peca,estado_peca) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";

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
            pst.setString(12, orcamento.getEstadoPeca());

            pst.executeUpdate();

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

    public void atualizarStatusPecaSolicitada(int id, String status) {
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

    public String buscarStatusPeca(int id) {
        String sql = "SELECT status_peca FROM tborcamentos WHERE id = ?";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("status_peca");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null; // Retorna null se o status não for encontrado
    }

    public void atualizaStatusPecaEEstadoPeca(int id, String status, String estadoPeca, String colaborador) {
        String sql = "update tborcamentos set status_peca=?, estado_peca =?,colaborador_entrega = ? where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, status);
            pst.setString(2, estadoPeca);
            pst.setString(3, colaborador);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "status da peca atualizada com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ArrayList<Orcamento> procurarPecasSolicitadas(Map<String, String> filtros) {
        StringBuilder sql = new StringBuilder("SELECT\n"
                + "    tborcamentos.id AS `ID`,\n"
                + "    tborcamentos.partnumber AS `Part Number`,\n"
                + "    tborcamentos.nome_peca AS `Descricao`,\n"
                + "    tborcamentos.quantidade AS `Qtd Pedida`,\n"
                + "    tborcamentos.motivo_consumo AS `Motivo`,\n"
                + "    tborcamentos.chassis AS `Chassis`,\n"
                + "    tborcamentos.status_peca AS `Status`\n"
                + "FROM\n"
                + "    tborcamentos\n");

        if (!filtros.isEmpty()) {
            sql.append("WHERE ");
            int count = 0;
            for (String key : filtros.keySet()) {
                if (count > 0) {
                    sql.append(" AND ");
                }
                sql.append(key).append(" = ?");
                count++;
            }
        }

        ArrayList<Orcamento> listaPecas = new ArrayList<>();

        try (PreparedStatement pst = conexao.prepareStatement(sql.toString())) {
            int index = 1;
            for (String value : filtros.values()) {
                pst.setString(index++, value);
            }

            try (ResultSet rs = pst.executeQuery()) {
                EstoqueDAO estoqueDAO = new EstoqueDAO(conexao);
                while (rs.next()) {
                    int id = rs.getInt("ID");
                    String partNumber = rs.getString("Part Number");
                    String nomePeca = rs.getString("Descricao");
                    int quantidade = rs.getInt("Qtd Pedida");
                    String motivo = rs.getString("Motivo");
                    String chassisValue = rs.getString("Chassis");
                    String statusValue = rs.getString("Status");
                    int quantidadeEstoque = estoqueDAO.retornaQuantidadeEmEstoque(partNumber);
                    String locacoes = estoqueDAO.retornaLocacoesPecaSolicitada(partNumber);

                    Orcamento peca = new Orcamento(id, partNumber, nomePeca, quantidade, motivo, chassisValue, statusValue, quantidadeEstoque, locacoes);
                    listaPecas.add(peca);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return listaPecas;
    }

    public ResultSet procuraPecasEntregues(String chassis, String etapa, String status) {
        StringBuilder sql = new StringBuilder("SELECT ")
                .append("tborcamentos.id AS `ID`, ")
                .append("tborcamentos.partnumber AS `Part Number`, ")
                .append("tborcamentos.nome_peca AS `Descricao`, ")
                .append("tborcamentos.quantidade AS `Qtd Pedida`, ")
                .append("tborcamentos.estado_peca AS `Estado Peça`, ")
                .append("tborcamentos.chassis AS `Chassis`, ")
                .append("tborcamentos.etapa AS `Etapa` ")
                .append("FROM tborcamentos ")
                .append("WHERE status_peca = ?");

        List<String> parametros = new ArrayList<>();
        parametros.add(status);

        if (chassis != null && !chassis.isEmpty()) {
            sql.append(" AND chassis = ?");
            parametros.add(chassis);
        }
        if (etapa != null && !etapa.isEmpty()) {
            sql.append(" AND etapa = ?");
            parametros.add(etapa);
        }

        ResultSet rs = null;

        try {
            PreparedStatement pst = conexao.prepareStatement(sql.toString());
            for (int i = 0; i < parametros.size(); i++) {
                pst.setString(i + 1, parametros.get(i));
            }
            rs = pst.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public Orcamento retornaObjetoOrcamento(int id) {
    String sql = "SELECT * FROM tborcamentos WHERE id = ?";
    Orcamento orcamento = null;

    try (PreparedStatement pst = conexao.prepareStatement(sql)) {
        pst.setInt(1, id);
        try (ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                orcamento = new Orcamento();
                orcamento.setId(rs.getInt("id"));
                orcamento.setPartNumber(rs.getString("partnumber"));
                orcamento.setNomePeca(rs.getString("nome_peca"));
                orcamento.setQuantidade(rs.getInt("quantidade"));
                orcamento.setColaboradorEntrega(rs.getString("colaborador_entrega"));
                orcamento.setColaboradorPedido(rs.getString("colaborador_pedido"));
                orcamento.setMotivoConsumo(rs.getString("motivo_consumo"));
                orcamento.setEtapa(rs.getString("etapa"));
                orcamento.setSessao(rs.getString("sessao"));
                orcamento.setChassis(rs.getString("chassis"));
                orcamento.setEixoLado(rs.getString("eixo_lado"));
                orcamento.setNumeroMotorCambio(rs.getString("numero_motor_cambio"));
                orcamento.setEstadoPeca(rs.getString("estado_peca"));
                orcamento.setStatusPeca(rs.getString("status_peca"));
                }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e);
    }

    return orcamento;
}

    
    
    
    
}