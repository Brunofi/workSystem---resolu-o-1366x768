/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.UsuarioDAO;
import br.com.porschegt3cup.model.Usuario;
import br.com.porschegt3cup.view.TelaUsuario;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class TelaUsuarioController {

    private TelaUsuario telaUsuario;
    Connection conexao = null;

    public TelaUsuarioController(TelaUsuario telaUsuario) {
        this.telaUsuario = telaUsuario;
    }

    public void buscarUsuario() {
        conexao = ModuloConexao.conector();
        String login = telaUsuario.getTxtLogin().getText();
        Usuario usuario = new Usuario(login);
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        usuario = usuarioDao.buscarUsuarioPorLogin(usuario);

        if (usuario != null) {
            String id = String.valueOf(usuario.getId());
            telaUsuario.getTxtId().setText(id);
            telaUsuario.getTxtLogin().setText(usuario.getLogin());
            telaUsuario.getTxtNome().setText(usuario.getNome());
            telaUsuario.getTxtSenha().setText(usuario.getSenha());
            telaUsuario.getCboPerfil().setSelectedItem(usuario.getPerfil());
            //conexao.close();

        } else {

            apagarCampos();
        }

    }

    private void apagarCampos() {
        telaUsuario.getTxtId().setText(null);
        telaUsuario.getTxtLogin().setText(null);
        telaUsuario.getTxtNome().setText(null);
        telaUsuario.getTxtSenha().setText(null);
        telaUsuario.getCboPerfil().setSelectedItem(null);

    }

    public void inserirUsuario() {
        conexao = ModuloConexao.conector();
        String nome = telaUsuario.getTxtNome().getText();
        String login = telaUsuario.getTxtLogin().getText();
        String senha = telaUsuario.getTxtSenha().getText();
        String perfil = telaUsuario.getCboPerfil().getSelectedItem().toString();
        Usuario usuario = new Usuario(nome, login, senha, perfil);
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        try {
            usuarioDao.InserirUsuario(usuario);
            apagarCampos();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Houve um problema, não foi possivel cadastrar o usuario");

        }

    }

}
