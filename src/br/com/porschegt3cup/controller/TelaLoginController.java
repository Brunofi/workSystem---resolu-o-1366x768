/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.UsuarioDAO;
import br.com.porschegt3cup.model.Usuario;
import br.com.porschegt3cup.view.TelaLogin;
import br.com.porschegt3cup.view.TelaPrincipal;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class TelaLoginController {

    private TelaLogin telaLogin;
    Connection conexao = null;
    public static String colaborador;

    public TelaLoginController(TelaLogin telaLogin) {
        this.telaLogin = telaLogin;
    }

    public void mostrarIconeConxaoBancoDados() {
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            telaLogin.getLblStatus().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/dbok.png")));
        } else {
            telaLogin.getLblStatus().setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/porschegt3cup/icones/dbnok.png")));
        }
    }

    public void logar() {
        String login = telaLogin.getTxtLogin().getText();
        String senha = telaLogin.getTxtSenha().getText();

        try {

            conexao = ModuloConexao.conector();
            boolean logado;
            Usuario usuario = new Usuario(login, senha);
            UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
            logado = usuarioDao.logar(usuario);
            
             if (logado) {

                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
                telaPrincipal.getLblUsuario().setText(login);
                colaborador=login;
                telaLogin.dispose();
               
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha invalida");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
