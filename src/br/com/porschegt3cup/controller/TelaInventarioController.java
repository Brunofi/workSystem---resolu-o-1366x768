/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.EstoqueDAO;
import br.com.porschegt3cup.dao.LocacaoDAO;
import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.view.TelaInventario;
import java.sql.Connection;
import java.util.List;

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
    
    public void carregarLocacoes(){
        conexao = ModuloConexao.conector();
        LocacaoDAO locacaoDao = new LocacaoDAO(conexao);
        List<String> listaLocacoes = locacaoDao.buscaListaLocacoes();
        telaInventario.getCbLocacao().addItem("");
        for(String locacao:listaLocacoes){
            telaInventario.getCbLocacao().addItem(locacao);
        }
    
    }

    

    
    
    
    
}
