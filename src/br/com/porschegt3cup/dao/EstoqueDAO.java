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

    public void inserirPecaNoEstoque(int quantidade, int idPeca, int IdLocacao) {

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

    public ResultSet procurarPecaEstoquePorPartNumber(String peca) {
        String sql = "select\n"
                + "tbpecas.partnumber as `Part Number`,tbpecas.nome as `Nome da peça`,tbpecas.estado as `Estado`,\n"
                + "tbestoque.quantidade as Quantidade,\n"
                + "tblocacoes.locacao as Locação,tblocacoes.sub as `Sub-locação`,\n"
                + "tbestoque.id as `id estoque`,tbestoque.idpeca,tbestoque.idlocacao\n"
                + "from tbestoque\n"
                + "inner join \n"
                + "tbpecas on tbpecas.id = tbestoque.idpeca\n"
                + "inner join \n"
                + "tblocacoes ON tblocacoes.id = tbestoque.idlocacao\n"
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

    public ResultSet procurarPecaEstoquePorDescricao(String peca) {
        String sql = "select\n"
                + "tbpecas.partnumber as `Part Number`,tbpecas.nome as `Nome da peça`,tbpecas.estado as `Estado`,\n"
                + "tbestoque.quantidade as Quantidade,\n"
                + "tblocacoes.locacao as Locação,tblocacoes.sub as `Sub-locação`,\n"
                + "tbestoque.id as `id estoque`,tbestoque.idpeca,tbestoque.idlocacao\n"
                + "from tbestoque\n"
                + "inner join \n"
                + "tbpecas on tbpecas.id = tbestoque.idpeca\n"
                + "inner join \n"
                + "tblocacoes ON tblocacoes.id = tbestoque.idlocacao\n"
                + "where tbpecas.nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, "%" + peca + "%");
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

    public ResultSet procurarPecaEstoquePorLocacao(String locacao) {
        String sql = "select\n"
                + "tbestoque.id as `ID`,\n"
                + "tbestoque.quantidade as `QUANTIDADE`, \n"
                + "tbpecas.partnumber as `PART NUMBER`,tbpecas.nome as `DESCRIÇÂO`,tbpecas.estado as `ESTADO`,\n"
                + "tblocacoes.locacao as `LOCAÇÂO`,tblocacoes.sub as `SUB LOCAÇÂO`\n"
                + "from tbestoque\n"
                + "inner join\n"
                + "tbpecas on tbpecas.id = tbestoque.idpeca\n"
                + "inner join\n"
                + "tblocacoes on tblocacoes.id = tbestoque.idlocacao\n"
                + "where tblocacoes.locacao = ?\n"
                + "order by tblocacoes.sub;";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, locacao);
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Locação Vazia");
                return null;
            }

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;

    }

    public void subtrairQuantidadePecaNoEstoque(int id, int quantidade) {
        String sql = "UPDATE tbestoque SET quantidade = quantidade - ? WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, quantidade);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "subtração de quantidade em estoque realizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void adicionarQuantidadePecaNoEstoque(int id, int quantidade) {
        String sql = "UPDATE tbestoque SET quantidade = quantidade + ? WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, quantidade);
            pst.setInt(2, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adição de quantidade em estoque realizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarQuantidadePecaEstoque(int id, int quantidade) {
        String sql = "UPDATE tbestoque SET quantidade = ? WHERE id = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, quantidade);
            pst.setInt(2, id);
            pst.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Alteração de quantidade de peça realizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarLocacaoEstoque(int idEstoque, int idLocacao) {
        String sql = "UPDATE tbestoque SET idlocacao = ? WHERE id = ?";
        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setInt(1, idLocacao);
            pst.setInt(2, idEstoque);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alteração de locação realizado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int retornaQuantidadeEmEstoque(String partNumber) {
        int qtdEstoque = 0;
        String sql = "SELECT \n"
                + "    SUM(tbestoque.quantidade) AS `QUANTIDADE TOTAL EM ESTOQUE`\n"
                + "FROM \n"
                + "    tbestoque\n"
                + "INNER JOIN \n"
                + "    tbpecas ON tbpecas.id = tbestoque.idpeca\n"
                + "WHERE \n"
                + "    tbpecas.partnumber = ?";

        try (PreparedStatement pst = conexao.prepareStatement(sql)) {
            pst.setString(1, partNumber);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    qtdEstoque = rs.getInt("QUANTIDADE TOTAL EM ESTOQUE");
                }
            }
        } catch (Exception e) {
            // Opcional: Imprima o erro para depuração
            e.printStackTrace();
        }

        return qtdEstoque;
    }

    public String retornaLocacoesPecaSolicitada(String partNumber) {
    StringBuilder locacoes = new StringBuilder();
    String sql = "SELECT \n"
            + "    tblocacoes.locacao AS `LOCAÇÃO`,\n"
            + "    tblocacoes.sub AS `SUB LOCAÇÃO`\n"
            + "FROM\n"
            + "    tbestoque\n"
            + "INNER JOIN\n"
            + "    tbpecas ON tbpecas.id = tbestoque.idpeca\n"
            + "INNER JOIN\n"
            + "    tblocacoes ON tblocacoes.id = tbestoque.idlocacao\n"
            + "WHERE\n"
            + "    tbpecas.partnumber = ?\n"
            + "GROUP BY\n"
            + "    tblocacoes.locacao, tblocacoes.sub";
    
    try (PreparedStatement pst = conexao.prepareStatement(sql)) {
        pst.setString(1, partNumber);
        try (ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                if (locacoes.length() > 0) {
                    locacoes.append("/");
                }
                locacoes.append(rs.getString("LOCAÇÃO"))
                        .append(" - ")
                        .append(rs.getString("SUB LOCAÇÃO"));
            }
        }
    } catch (Exception e) {
        // Opcional: Imprima o erro para depuração
        e.printStackTrace();
    }
    
    // Verifica se locacoes está vazia e retorna "não localizada" se não houver resultados
    if (locacoes.length() == 0) {
        return "não localizada";
    }
    
    return locacoes.toString();
}


}
