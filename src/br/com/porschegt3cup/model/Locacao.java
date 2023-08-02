/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.model;

/**
 *
 * @author bruno
 */
public class Locacao {
    private int id;
    private String locacao;
    private String sub;

    public Locacao(int id, String locacao, String sub) {
        this.id = id;
        this.locacao = locacao;
        this.sub = sub;
    }

    public Locacao(int id) {
        this.id = id;
    }

    public Locacao(String locacao, String sub) {
        this.locacao = locacao;
        this.sub = sub;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocacao() {
        return locacao;
    }

    public void setLocacao(String locacao) {
        this.locacao = locacao;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
    
    
    
}
