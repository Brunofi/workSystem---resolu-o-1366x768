/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.dao.ModuloConexao;
import br.com.porschegt3cup.dao.SaidaDAO;
import br.com.porschegt3cup.view.TelaSaidaPeca;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class TelaSaidaPecaController {

    private TelaSaidaPeca telaSaidaPeca;
    Connection conexao = null;

    public TelaSaidaPecaController(TelaSaidaPeca telaSaidaPeca) {
        this.telaSaidaPeca = telaSaidaPeca;
    }

    public void carregarListaDeColaboradores() {
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> nomesColaboradores = saidaDao.buscarListaDeColaboradores();
        telaSaidaPeca.getCbColaboradorEntrega().addItem("");
        telaSaidaPeca.getCbColaboradorRetira().addItem("");
        for (String nome : nomesColaboradores) {
            telaSaidaPeca.getCbColaboradorEntrega().addItem(nome);
            telaSaidaPeca.getCbColaboradorRetira().addItem(nome);
        }
    }
    
    public void carregarListaDeChassisSaida(){
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        for (String chassis : listaChassis) {
            telaSaidaPeca.getCbChassis().addItem(chassis);
        }
    }
    
    public void carregarListaDeChassisCedente(){
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaChassis = carregarChassis();
        for (String chassis : listaChassis) {
            telaSaidaPeca.getCbChassisCedente().addItem(chassis);
        }
    }
    
    
    public List <String> carregarChassis(){
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        return saidaDao.buscarListaDeChassis();
    }
    
    public void carregarListaDeSessoes(){
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaSessoes = saidaDao.buscarListaDeSessoes();
        telaSaidaPeca.getCbSessao().addItem("");
        for (String sessao : listaSessoes) {
            telaSaidaPeca.getCbSessao().addItem(sessao);
        }
    }
    
    public void carregarListaDeEtapas(){
        conexao = ModuloConexao.conector();
        SaidaDAO saidaDao = new SaidaDAO(conexao);
        List<String> listaEtapas = saidaDao.buscarListaDeEtapas();
        telaSaidaPeca.getCbEtapa().addItem("");
        for (String etapa : listaEtapas) {
            telaSaidaPeca.getCbEtapa().addItem(etapa);
        }
    }

}
