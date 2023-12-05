/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.UsuarioDAO;
import br.com.porschegt3cup.model.Usuario;
import br.com.porschegt3cup.view.TelaCadastroEstoque;
import br.com.porschegt3cup.view.TelaCadastroPeca;
import br.com.porschegt3cup.view.TelaEntradaPeca;
import br.com.porschegt3cup.view.TelaCadastroLocacao;
import br.com.porschegt3cup.view.TelaPrincipal;
import br.com.porschegt3cup.view.TelaCadastroUsuario;
import br.com.porschegt3cup.view.TelaDesfazerLancamento;
import br.com.porschegt3cup.view.TelaInventario;
import br.com.porschegt3cup.view.TelaPecasEmRecuperacao;
import br.com.porschegt3cup.view.TelaSaidaPeca;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class TelaPrincipalController {

    private TelaPrincipal telaPrincipal;
    Connection conexao = null;

    public TelaPrincipalController(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public void apresentarUsuarioData() {

        Date data = new Date();
        DateFormat dataFormatada = DateFormat.getDateInstance(DateFormat.SHORT);
        telaPrincipal.getLblData().setText(dataFormatada.format(data));

    }

    public void fecharSistema() {

        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair do sistema", "Atenção", JOptionPane.YES_NO_OPTION);

        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);

        }

    }

    public void controlarAcessoPorPerfil() {
        conexao = ModuloConexao.conector();
        String login = telaPrincipal.getLblUsuario().getText();
        Usuario usario = new Usuario(login);
        UsuarioDAO usuarioDao = new UsuarioDAO(conexao);
        String perfil = usuarioDao.decubrirPerfil(usario);

        if (perfil.equals("gerente")) {
            telaPrincipal.getMenuPeca().setEnabled(true);
            telaPrincipal.getMenuLocacao().setEnabled(true);
            telaPrincipal.getMenuUsuario().setEnabled(true);
            telaPrincipal.getMenuColaborador().setEnabled(true);
            telaPrincipal.getMenuEstoque().setEnabled(true);
            
        }

        //System.out.println(perfil);
    }

    public void abrirTelaUsuario() throws PropertyVetoException {
        TelaCadastroUsuario telaUsuario = new TelaCadastroUsuario();
        telaUsuario.setVisible(true);
        telaPrincipal.getDesktop().add(telaUsuario);
        telaUsuario.setMaximum(true);
    }

    public void abrirTelaLocacao() throws PropertyVetoException {
        TelaCadastroLocacao telaLocacao = new TelaCadastroLocacao();
        telaLocacao.setVisible(true);
        telaPrincipal.getDesktop().add(telaLocacao);
        telaLocacao.setMaximum(true);

    }

    public void abrirTelaCadastroPeca() throws PropertyVetoException {
        TelaCadastroPeca telaCadastroPeca = new TelaCadastroPeca();
        telaCadastroPeca.setVisible(true);
        telaPrincipal.getDesktop().add(telaCadastroPeca);
        telaCadastroPeca.setMaximum(true);

    }

    public void abrirTelaCadastroEstoque() throws PropertyVetoException {
        TelaCadastroEstoque telaCadastroEstoque = new TelaCadastroEstoque();
        telaCadastroEstoque.setVisible(true);
        telaPrincipal.getDesktop().add(telaCadastroEstoque);
        telaCadastroEstoque.setMaximum(true);
    }

    public void abrirTelaEntradaPeca() throws PropertyVetoException {
        TelaEntradaPeca telaEntradaPeca = new TelaEntradaPeca();
        telaEntradaPeca.setVisible(true);
        telaPrincipal.getDesktop().add(telaEntradaPeca);
        telaEntradaPeca.setMaximum(true);
    }

    public void abrirTelaSaidaPeca() throws PropertyVetoException {
        
        TelaSaidaPeca telaSaidaPeca = new TelaSaidaPeca();
        telaSaidaPeca.setVisible(true);
        telaPrincipal.getDesktop().add(telaSaidaPeca);
        telaSaidaPeca.setMaximum(true);
     }
    
    public void abrirTelaInventario() throws PropertyVetoException{
        TelaInventario telaInventario = new TelaInventario();
        telaInventario.setVisible(true);
        telaPrincipal.getDesktop().add(telaInventario);
        telaInventario.setMaximum(true);
    }

    public void abrirTelaRecuperacaoPecas() throws PropertyVetoException {
    TelaPecasEmRecuperacao telaPecasEmRecuperacao = new TelaPecasEmRecuperacao();
    telaPecasEmRecuperacao.setVisible(true);
    telaPrincipal.getDesktop().add(telaPecasEmRecuperacao);
    telaPecasEmRecuperacao.setMaximum(true);
}

    public void abrirTelaDesfazerLancamento() throws PropertyVetoException {
        TelaDesfazerLancamento telaDesfazerLancamento = new TelaDesfazerLancamento();
        telaDesfazerLancamento.setVisible(true);
        telaPrincipal.getDesktop().add(telaDesfazerLancamento);
        telaDesfazerLancamento.setMaximum(true);
        }

  






}
