/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.model;

/**
 *
 * @author Bruno
 */
public class PecaRecuperacao {
    
    private int id;
    private int idSaidaEstoque;
    private String situacao;
    private String setor;

    public PecaRecuperacao(int idSaidaEstoque, String situacao, String setor) {
        this.idSaidaEstoque = idSaidaEstoque;
        this.situacao = situacao;
        this.setor = setor;
    }

    public PecaRecuperacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSaidaEstoque() {
        return idSaidaEstoque;
    }

    public void setIdSaidaEstoque(int idSaidaEstoque) {
        this.idSaidaEstoque = idSaidaEstoque;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    
    
}
