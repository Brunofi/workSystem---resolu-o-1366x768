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

    public void inserirPecaRecuperacao(PecaRecuperacao pecaRecuperacao) {

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

    public void atualizarStatusPecaEmRecuperacao(int id, String situacao, String setor) {
        String sql = "update tbcontrole_recuperacao_pecas set situacao=?, setor=? where id=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, situacao);
            pst.setString(2, setor);
            pst.setInt(3, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peca atualizada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ResultSet procurarPecasTabelaRecuperacaoPorPartNumber(String partNumber) {
        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.partnumber like ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, partNumber + "%");
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Peça não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public ResultSet procurarPecasTabelaRecuperacaoPorPartNumberESetor(String partNumber, String setor) {

        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.partnumber like ?  and tbcontrole_recuperacao_pecas.setor =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, partNumber + "%");
            pst.setString(2, setor);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ResultSet procurarPecasTabelaRecuperacaoPorPartNumberESituacao(String partNumber, String situacao) {

        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.partnumber like ?  and tbcontrole_recuperacao_pecas.situacao =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, partNumber + "%");
            pst.setString(2, situacao);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ResultSet procurarPecasTabelaRecuperacaoPorPartNumberESituacaoESetor(String partNumber, String situacao, String setor) {

        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.partnumber like ?  and tbcontrole_recuperacao_pecas.situacao =? and tbcontrole_recuperacao_pecas.setor =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, partNumber + "%");
            pst.setString(2, situacao);
            pst.setString(3, setor);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public ResultSet procurarPecasTabelaRecuperacaoPorDescricao(String descricao) {
        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.nome like ?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao + "%");
            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Peça não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ResultSet procurarPecasTabelaRecuperacaoPorDescricaoESituacaoESetor(String descricao, String situacao, String setor) {

        String sql = "SELECT \n"
                + "    tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.nome like ?  and tbcontrole_recuperacao_pecas.situacao =? and tbcontrole_recuperacao_pecas.setor =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao + "%");
            pst.setString(2, situacao);
            pst.setString(3, setor);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ResultSet procurarPecasTabelaRecuperacaoPorDescricaoESetor(String descricao, String setor) {

        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.nome like ?  and tbcontrole_recuperacao_pecas.setor =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao + "%");
            pst.setString(2, setor);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public ResultSet procurarPecasTabelaRecuperacaoPorDescricaoESituacao(String descricao, String situacao) {

        String sql = "SELECT \n"
                + "	tbcontrole_recuperacao_pecas.id as `ID`,\n"
                + "    tbpecas.partnumber as `Part Number`,\n"
                + "    tbpecas.nome as `Descrição`,\n"
                + "    tbpecas.subsistema as `Sub Sistema`,\n"
                + "    tbsaida.chassis as `Chassis`,\n"
                + "    tbsaida.etapa as `Etapa`,\n"
                + "    tbsaida.data_saida as `Data Troca`,\n"
                + "    tbcontrole_recuperacao_pecas.situacao as `SITUACAO`,\n"
                + "    tbcontrole_recuperacao_pecas.setor as `SETOR`\n"
                + "FROM \n"
                + "    tbcontrole_recuperacao_pecas\n"
                + "INNER JOIN \n"
                + "    tbsaida ON tbsaida.id = tbcontrole_recuperacao_pecas.idsaida_estoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbsaida.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.nome like ?  and tbcontrole_recuperacao_pecas.situacao =?;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, descricao + "%");
            pst.setString(2, situacao);

            rs = pst.executeQuery();

            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "busca não encontrada");
                return null;
            }

            return rs;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
