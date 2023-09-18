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
public class Estoque {

    private int id;
    private int quantidade;
    private int idPeca;
    private int idLocacao;

    public Estoque() {
    }

    public Estoque(int id, int quantidade, int idPeca, int idLocacao) {
        this.id = id;
        this.quantidade = quantidade;
        this.idPeca = idPeca;
        this.idLocacao = idLocacao;
    }

    public Estoque(int quantidade, int idPeca, int idLocacao) {
        this.quantidade = quantidade;
        this.idPeca = idPeca;
        this.idLocacao = idLocacao;
    }

    public Estoque(int id, int quantidade) {
        this.id = id;
        this.quantidade = quantidade;
    }
    
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    @Override
    public String toString() {
        return "Estoque{" + "id=" + id + ", quantidade=" + quantidade + ", idPeca=" + idPeca + ", idLocacao=" + idLocacao + '}';
    }
    
    
    

}
