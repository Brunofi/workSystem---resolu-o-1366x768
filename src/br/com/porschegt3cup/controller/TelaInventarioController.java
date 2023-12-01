/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.InventarioDao;
import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.model.Inventario;
import br.com.porschegt3cup.view.TelaInventario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruno
 */
public class TelaInventarioController {

    private TelaInventario telaInventario;
    Connection conexao = null;

    public TelaInventarioController(TelaInventario telaInventario) {
        this.telaInventario = telaInventario;
    }

    public void carregarLocacoes() {
        conexao = ModuloConexao.conector();
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        Set<String> listaLocacoes = locacaoDao.buscaListaLocacoes();
        telaInventario.getCbLocacao().addItem("");
        for (String locacao : listaLocacoes) {
            telaInventario.getCbLocacao().addItem(locacao);
        }
    }

    public void preencheTabelaInventario(ResultSet rs, JTable jTable) {
        if (rs != null) {
            try {
                // Obtém o modelo da tabela
                DefaultTableModel model = (DefaultTableModel) jTable.getModel();

                // Limpa as linhas existentes, se houver
                model.setRowCount(0);

                // Adiciona as linhas do ResultSet ao modelo
                while (rs.next()) {
                    Object[] row = {
                        rs.getInt("ID"),
                        rs.getString("PART NUMBER"),
                        rs.getString("DESCRIÇÂO"),
                        rs.getString("LOCAÇÂO"),
                        rs.getString("SUB LOCAÇÂO"),
                        rs.getString("QUANTIDADE"),
                        "" // Adicione uma coluna vazia editável
                    };
                    model.addRow(row);
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela: " + e.getMessage());
            }
        }

    }

    /*
    public void preencheListaLocacaoInventariada(ResultSet rs) {
        if (rs != null) {

            try {
                Inventario inventario = new Inventario();

                while (rs.next()) {
                    inventario.setIdEstoque(rs.getInt("ID"));
                    inventario.setQuantidadeVelha(rs.getInt("QUANTIDADE"));
                    this.inventario.add(inventario);

                }
                
                for(Inventario i: this.inventario){
                    System.out.println(i.toString());
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }*/

    public void obterPecasNaTabelaDeInventario() {
        conexao = ModuloConexao.conector();
        String locacao = telaInventario.getCbLocacao().getSelectedItem().toString();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);
        ResultSet rs = estoqueDao.procurarPecaEstoquePorLocacao(locacao);
        preencheTabelaInventario(rs, telaInventario.getTblInventario());
        Utils.permitirSelecaoApenasUmaLinha(telaInventario.getTblInventario());
        Utils.ajustarLarguraColunas(telaInventario.getTblInventario());
        Utils.tornarColunasNaoEditaveis(telaInventario.getTblInventario(), 6);

    }
    
    public void aplicarInventario(){
        atualizarQuantidadeConferidaNoEstoque();
        inserirDadosDeInventario();
        apagarCampos();
    
    }

    public void atualizarQuantidadeConferidaNoEstoque() {
        conexao = ModuloConexao.conector();
        EstoqueDAO estoqueDao = new EstoqueDAO(conexao);

        try {
            if (Utils.tabelaEstaPreenchida(telaInventario.getTblInventario())) {
                DefaultTableModel model = (DefaultTableModel) telaInventario.getTblInventario().getModel();
                int numRows = model.getRowCount();

                for (int i = 0; i < numRows; i++) {
                    int idEstoque = (int) model.getValueAt(i, 0); // Obtém o ID do estoque da primeira coluna
                    Object quantidadeConferida = model.getValueAt(i, 6);
                    try {
                        if (quantidadeConferida != null && !quantidadeConferida.toString().isEmpty()) {
                            quantidadeConferida = Integer.parseInt(quantidadeConferida.toString());
                        } else {
                            quantidadeConferida = 0; // Defina um valor padrão quando estiver vazio
                        }
                    } catch (NumberFormatException e) {
                        // Tratamento para o caso de não ser um número válido
                        quantidadeConferida = 0;
                    }

                    // Chama o método para atualizar a quantidade na base de dados
                    estoqueDao.alterarQuantidadePecaEstoque(idEstoque, (int) quantidadeConferida);

                }
                JOptionPane.showMessageDialog(null, "Alteração de quantidade de peça realizado com sucesso");
                //apagarCampos();

            } else {
                JOptionPane.showMessageDialog(null, "A tabela está vazia. Preencha os dados antes de atualizar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
/*
    public void inserirDadosDeInventario() {
        conexao = ModuloConexao.conector();
        InventarioDao inventarioDao = new InventarioDao(conexao);
        List<Inventario> dados = new ArrayList<>();

        try {
            if (Utils.tabelaEstaPreenchida(telaInventario.getTblInventario())) {
                DefaultTableModel model = (DefaultTableModel) telaInventario.getTblInventario().getModel();
                int numRows = model.getRowCount();

                for (int i = 0; i < numRows; i++) {
                    int idEstoque = (int) model.getValueAt(i, 0); // Obtém o ID do estoque da primeira coluna
                    Object quantidadeAntiga =  model.getValueAt(i, 5);
                    Object quantidadeConferida = model.getValueAt(i, 6);
                    String colaborador = Utils.colaboradorLogado;
                    try {
                        if (quantidadeConferida != null && !quantidadeConferida.toString().isEmpty()) {
                            quantidadeAntiga = Integer.parseInt(quantidadeAntiga.toString());
                            quantidadeConferida = Integer.parseInt(quantidadeConferida.toString());
                            
                        } else {
                            quantidadeConferida = 0; // Defina um valor padrão quando estiver vazio
                        }
                    } catch (NumberFormatException e) {
                        // Tratamento para o caso de não ser um número válido
                        quantidadeConferida = 0;
                    }
                    //adiciona na lista 
                    dados.add(new Inventario(idEstoque, (Integer)quantidadeAntiga, (Integer)quantidadeConferida, colaborador));
                    
                }
                inventarioDao.inserirDadosNoInventario(dados);
                JOptionPane.showMessageDialog(null, "Tabela de controle de inventario atualizada com sucesso");
                

            } else {
                JOptionPane.showMessageDialog(null, "A tabela está vazia. Preencha os dados antes de atualizar.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }*/
    
    public void inserirDadosDeInventario() {
    conexao = ModuloConexao.conector();
    InventarioDao inventarioDao = new InventarioDao(conexao);
    List<Inventario> dados = new ArrayList<>();

    try {
        if (Utils.tabelaEstaPreenchida(telaInventario.getTblInventario())) {
            DefaultTableModel model = (DefaultTableModel) telaInventario.getTblInventario().getModel();
            int numRows = model.getRowCount();

            for (int i = 0; i < numRows; i++) {
                int idEstoque = (int) model.getValueAt(i, 0); // Obtém o ID do estoque da primeira coluna
                Object quantidadeAntiga = model.getValueAt(i, 5);
                Object quantidadeConferida = model.getValueAt(i, 6);
                String colaborador = Utils.colaboradorLogado;

                // Tratar valores nulos ou vazios como zero
                int quantidadeAntigaInt = (quantidadeAntiga != null && !quantidadeAntiga.toString().isEmpty())
                        ? Integer.parseInt(quantidadeAntiga.toString())
                        : 0;

                int quantidadeConferidaInt = (quantidadeConferida != null && !quantidadeConferida.toString().isEmpty())
                        ? Integer.parseInt(quantidadeConferida.toString())
                        : 0;

                // Adicionar na lista
                dados.add(new Inventario(idEstoque, quantidadeAntigaInt, quantidadeConferidaInt, colaborador));
            }

            inventarioDao.inserirDadosNoInventario(dados);
            JOptionPane.showMessageDialog(null, "Tabela de controle de inventário atualizada com sucesso");

        } else {
            JOptionPane.showMessageDialog(null, "A tabela está vazia. Preencha os dados antes de atualizar.");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}


    public void apagarCampos() {
        DefaultTableModel tabela = (DefaultTableModel) telaInventario.getTblInventario().getModel();
        tabela.setRowCount(0);
        telaInventario.getCbLocacao().setSelectedItem(null);
        carregarLocacoes();
    }

}
