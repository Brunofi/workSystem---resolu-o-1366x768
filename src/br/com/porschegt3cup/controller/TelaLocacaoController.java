/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.model.Locacao;
import br.com.porschegt3cup.view.TelaLocacao;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class TelaLocacaoController {

    private TelaLocacao telaLocacao;
    Connection conexao = null;

    public TelaLocacaoController(TelaLocacao telaLocacao) {
        this.telaLocacao = telaLocacao;
    }
    
    private void apagarCampos() {
        telaLocacao.getTxtLocacao().setText(null);
        telaLocacao.getTxtSubLocacao().setText(null);
        telaLocacao.getTxtId().setText(null);
      

    }

    public void inserirLocacao() {
        conexao = ModuloConexao.conector();
        String nome = telaLocacao.getTxtLocacao().getText();
        String sub = telaLocacao.getTxtSubLocacao().getText();
        Locacao locacao = new Locacao(nome, sub);
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        try {
            locacaoDao.inserirLocacao(locacao);
            JOptionPane.showMessageDialog(null, "Locação cadastrado com sucesso");
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Houve um problema, não foi possivel cadastrar a Locação");
        }

    }

}
