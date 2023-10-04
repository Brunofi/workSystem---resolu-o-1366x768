/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.UsuarioDAO;
import br.com.porschegt3cup.model.Usuario;
import br.com.porschegt3cup.view.TelaCadastroUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author bruno
 */
public class TelaCadastroUsuarioController {

    private TelaCadastroUsuario telaUsuario;
    Connection conexao = null;
    Usuario usuario = null;
    String senha = null;

    public TelaCadastroUsuarioController(TelaCadastroUsuario telaUsuario) {
        this.telaUsuario = telaUsuario;
    }

    public void apagarCampos() {
        telaUsuario.getTxtLPesquisar().setText(null);
        telaUsuario.getTxtId().setText(null);
        telaUsuario.getTxtLogin().setText(null);
        telaUsuario.getTxtNome().setText(null);
        telaUsuario.getTxtSenha().setText(null);
        telaUsuario.getCboPerfil().setSelectedItem(null);
        telaUsuario.getBtnCadastrar().setEnabled(true);
        DefaultTableModel tabela = (DefaultTableModel) telaUsuario.getTblUsuario().getModel();
        tabela.setRowCount(0);

    }

    private void criaUsuario() {

        String login = telaUsuario.getTxtLogin().getText();
        String nome = telaUsuario.getTxtNome().getText();
        String senha = telaUsuario.getTxtSenha().getText();
        String perfil = telaUsuario.getCboPerfil().getSelectedItem().toString();
        Usuario usuario = new Usuario(nome, login, senha, perfil);
        this.usuario = usuario;

    }

    private void obtemSenha(int id) {
        conexao = ModuloConexao.conector();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        senha = usuarioDao.retornarSenha(id);

    }

    public void inserirUsuario() {
        conexao = ModuloConexao.conector();
        criaUsuario();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        usuarioDao.InserirUsuario(usuario);

    }

    public void procurarUsuario() {
        conexao = ModuloConexao.conector();
        String nome = telaUsuario.getTxtLPesquisar().getText();
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        ResultSet rs;
        rs = usuarioDao.buscarUsuarioPorNome(nome);
        if (rs != null) {
            telaUsuario.getTblUsuario().setModel(DbUtils.resultSetToTableModel(rs));
        }
    }

    public void preencheCampos() {
        if (Utils.linhaSelecionadaContemDados(telaUsuario.getTblUsuario())) {
            telaUsuario.getBtnCadastrar().setEnabled(false);
            int linhaSelecionada = telaUsuario.getTblUsuario().getSelectedRow();
            telaUsuario.getTxtId().setText(telaUsuario.getTblUsuario().getModel().getValueAt(linhaSelecionada, 0).toString());
            telaUsuario.getTxtLogin().setText(telaUsuario.getTblUsuario().getModel().getValueAt(linhaSelecionada, 1).toString());
            telaUsuario.getTxtNome().setText(telaUsuario.getTblUsuario().getModel().getValueAt(linhaSelecionada, 2).toString());
            telaUsuario.getCboPerfil().setSelectedItem(telaUsuario.getTblUsuario().getModel().getValueAt(linhaSelecionada, 3).toString());
            int id = Integer.parseInt(telaUsuario.getTxtId().getText());
            obtemSenha(id);
            telaUsuario.getTxtSenha().setText(senha);

        } else {
            JOptionPane.showMessageDialog(null, "è necessario conter dados selecionados para realizar a operação");
        }

    }

    public void alterarUsuario() {
        if (Utils.linhaSelecionadaContemDados(telaUsuario.getTblUsuario())) {
            conexao = ModuloConexao.conector();
            int id = Integer.parseInt(telaUsuario.getTxtId().getText());
            String login = telaUsuario.getTxtLogin().getText();
            String nome = telaUsuario.getTxtNome().getText();
            String senha = telaUsuario.getTxtSenha().getText();
            String perfil = telaUsuario.getCboPerfil().getSelectedItem().toString();
            Usuario usuario = new Usuario(id, nome, login, senha, perfil);
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            usuarioDao.alterarUsuario(usuario);

        } else {
            JOptionPane.showMessageDialog(null, "É necessário que a linha contenha dados para ser selecionada");

        }
    }

}
