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

    public void inserirPeca(Peca peca) {
        String sql = "insert into tbpecas (nome,partnumber,peso,ncm,estado,modelocarro,subsistema,"
                + "fabricante,qtdmin,qtdmed,qtdmax,preco,ptnumber_similar) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, peca.getNome());
            pst.setString(2, peca.getPartNumber());
            pst.setString(3, peca.getPeso());
            pst.setString(4, peca.getNcm());
            pst.setString(5, peca.getEstado());
            pst.setString(6, peca.getModeloCarro());
            pst.setString(7, peca.getSubSistema());
            pst.setString(8, peca.getFabricante());
            pst.setInt(9, peca.getQtdMin());
            pst.setInt(10, peca.getQtdMed());
            pst.setInt(11, peca.getQtdMax());
            pst.setBigDecimal(12, peca.getPreco());
            pst.setString(13, peca.getPartNumberSimilar());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peça cadastrada com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void alterarPeca(Peca peca) {
        String sql = "update tbpecas set nome=?, partnumber=?, peso=?, ncm=?,"
                + " estado=?, modelocarro=?, subsistema=?, fabricante=?, qtdmin=?,"
                + " qtdmed=?, qtdmax=?, preco=?, ptnumber_similar=? where id=?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, peca.getNome());
            pst.setString(2, peca.getPartNumber());
            pst.setString(3, peca.getPeso());
            pst.setString(4, peca.getNcm());
            pst.setString(5, peca.getEstado());
            pst.setString(6, peca.getModeloCarro());
            pst.setString(7, peca.getSubSistema());
            pst.setString(8, peca.getFabricante());
            pst.setInt(9, peca.getQtdMin());
            pst.setInt(10, peca.getQtdMed());
            pst.setInt(11, peca.getQtdMax());
            pst.setBigDecimal(12, peca.getPreco());
            pst.setString(13, peca.getPartNumberSimilar());
            pst.setInt(14, peca.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peca alterada com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public ResultSet pesquisarPorPartNumber(String peca) {
        String sql = "select id as ID, nome as `NOME DA PEÇA`, partnumber as `PART NUMBER`, estado as `ESTADO DA PEÇA` from tbpecas where partnumber like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, peca + "%");
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Nenhuma peça encontrada");
                return null;
            }

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public ResultSet pesquisarPorNome(String peca) {
        String sql = "select id as ID, nome as `NOME DA PEÇA`, partnumber as `PART NUMBER` from tbpecas where nome like ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "%" + peca + "%");
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Nenhuma peça encontrada");
                return null;
            }
            
            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public Peca pesquisarPorId(int idPeca) {
        try {
            String sql = "select * from tbpecas where id=?";
            Peca peca = new Peca();
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idPeca);
            rs = pst.executeQuery();
            if (rs.next()) {
                peca.setId(idPeca);
                peca.setNome(rs.getString("nome"));
                peca.setPartNumber(rs.getString("partnumber"));
                peca.setPeso(rs.getString("peso"));
                peca.setNcm(rs.getString("ncm"));
                peca.setEstado(rs.getString("estado"));
                peca.setModeloCarro(rs.getString("modelocarro"));
                peca.setSubSistema(rs.getString("subsistema"));
                peca.setFabricante(rs.getString("fabricante"));
                peca.setQtdMin(rs.getInt("qtdmin"));
                peca.setQtdMed(rs.getInt("qtdmed"));
                peca.setQtdMax(rs.getInt("qtdmax"));
                peca.setPreco(rs.getBigDecimal("preco"));
                peca.setPartNumberSimilar(rs.getString("ptnumber_similar"));

                return peca;

            } else {
                JOptionPane.showMessageDialog(null, "Peça Não encontrada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public void removerPeca(int id) {
        String sql = "delete from tbpecas where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Peca removida com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public ResultSet procurarPecaRetorna2Colunas(String peca) {
    String sql = "select distinct\n"
            + "tbpecas.partnumber as `Part Number`, tbpecas.nome as `Nome da peça`\n"
            + "from tbpecas\n"
            + "where tbpecas.partnumber like ?";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, peca + "%");
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


}
