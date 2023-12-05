/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Estoque;
import br.com.porschegt3cup.model.Saida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Bruno
 */
public class SaidaDAO {

    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public SaidaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<String> buscarListaDeColaboradores() {
        List<String> nomesColaboradores = new ArrayList<>();
        String sql = "select * from colaboradores";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String nomeColaborador = rs.getString("nome");
                nomesColaboradores.add(nomeColaborador);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return nomesColaboradores;

    }

    public List<String> buscarListaDeChassis() {
        List<String> listaChassis = new ArrayList<>();
        String sql = "select * from chassis";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String chassis = rs.getString("numeral");
                listaChassis.add(chassis);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return listaChassis;

    }

    public List<String> buscarListaDeSessoes() {
        List<String> listaSessoes = new ArrayList<>();
        String sql = "select * from sessoes";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String sessao = rs.getString("sessao");
                listaSessoes.add(sessao);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaSessoes;
    }

    public List<String> buscarListaDeEtapas() {
        List<String> listaEtapas = new ArrayList<>();
        String sql = "select * from etapas";
        try {
            Statement statement = conexao.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                String etapa = rs.getString("etapa");
                listaEtapas.add(etapa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return listaEtapas;
    }

    /*
    public void registrarDadosDeSaidaNoEstoque(Saida saida) {
        String sql = "insert into tbsaida(quantidade,tipo_consumo,colaborador_entrega,colaborador_retirada,colaborador_lancamento,motivo_consumo,etapa,sessao,chassis,chassis_cedente,eixo_lado,idpeca,idlocacao)values(?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, saida.getQuantidadeSaida());
            pst.setString(2, saida.getTipoMovimentacao());
            pst.setString(3, saida.getColaboradorEntrega());
            pst.setString(4, saida.getColaboradorRetira());
            pst.setString(5, saida.getColaboradorLanca());
            pst.setString(6, saida.getMotivoConsumo());
            pst.setString(7, saida.getEtapa());
            pst.setString(8, saida.getSessao());
            pst.setString(9, saida.getChassis());
            pst.setString(10, saida.getChassisCedente());
            pst.setString(11, saida.getEixoLado());
            pst.setInt(12, saida.getIdPeca());
            pst.setInt(13, saida.getIdLocacao());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro de saída de peça realizado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }*/

    public int registrarDadosDeSaidaNoEstoque(Saida saida, Estoque estoque) {
        String sql = "insert into tbsaida(quantidade,tipo_consumo,colaborador_entrega,colaborador_retirada,colaborador_lancamento,motivo_consumo,etapa,sessao,chassis,chassis_cedente,eixo_lado,idpeca,idlocacao,idestoque) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            // Configurar o PreparedStatement para retornar o ID gerado
            pst = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pst.setInt(1, saida.getQuantidadeSaida());
            pst.setString(2, saida.getTipoMovimentacao());
            pst.setString(3, saida.getColaboradorEntrega());
            pst.setString(4, saida.getColaboradorRetira());
            pst.setString(5, saida.getColaboradorLanca());
            pst.setString(6, saida.getMotivoConsumo());
            pst.setString(7, saida.getEtapa());
            pst.setString(8, saida.getSessao());
            pst.setString(9, saida.getChassis());
            pst.setString(10, saida.getChassisCedente());
            pst.setString(11, saida.getEixoLado());
            pst.setInt(12, saida.getIdPeca());
            pst.setInt(13, saida.getIdLocacao());
            pst.setInt(14, estoque.getId());
            // Executar a atualização e obter o ID gerado
            pst.executeUpdate();

            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGerado = generatedKeys.getInt(1);
                JOptionPane.showMessageDialog(null, "Registro de saída de peça realizado com sucesso! ID gerado: " + idGerado);
                return idGerado;  // Retornar o ID gerado
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao obter o ID gerado.");
                return -1;  // Ou outro valor padrão ou indicativo de falha
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return -1;  // Ou outro valor padrão ou indicativo de falha
        } finally {
            // Lembre-se de fechar os recursos, como PreparedStatement
            // Aqui você deve fechar o PreparedStatement, a conexão, etc.
        }
    }

    public ResultSet procurarLancamentoPecasPorChassisEEtapa(String chassis, String etapa) {
        
        String sql = "select\n"
                + "tbpecas.partnumber as `Part Number`,tbpecas.nome as `Descrição`, tbpecas.estado,\n"
                + "tbsaida.quantidade as `Qtd`, tbsaida.motivo_consumo as `Motivo`, tbsaida.chassis as `Chassis`,tbsaida.etapa as `Etapa`, tbsaida.id as `ID SAIDA`, tbsaida.idestoque as `ID estoque`\n"
                + "from tbsaida\n"
                + "inner join\n"
                + "tbpecas on tbpecas.id = tbsaida.idpeca\n"
                + " where tbsaida.chassis = ? and tbsaida.etapa = ? ;";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,chassis);
            pst.setString(2,etapa);
            rs = pst.executeQuery();
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Não existem peças lançadas para o chasis e/ou preiodo selecionado");
                return null;
            }
            
            return rs;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    public void apagarRegistroDePecaLancada(int id){
     
        String sql = "delete from tbsaida where id =?";
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "peça removida da tabela SAÍDA");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    
    }

}
