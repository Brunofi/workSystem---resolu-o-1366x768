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
public class Inventario {
    
    private int id;
    private int idEstoque;
    private int quantidadeVelha;
    private int quantidaAtual;

    public Inventario(int idEstoque, int quantidadeVelha, int quantidaAtual) {
        this.idEstoque = idEstoque;
        this.quantidadeVelha = quantidadeVelha;
        this.quantidaAtual = quantidaAtual;
    }

    public Inventario() {
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getQuantidadeVelha() {
        return quantidadeVelha;
    }

    public void setQuantidadeVelha(int quantidadeVelha) {
        this.quantidadeVelha = quantidadeVelha;
    }

    public int getQuantidaAtual() {
        return quantidaAtual;
    }

    public void setQuantidaAtual(int quantidaAtual) {
        this.quantidaAtual = quantidaAtual;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", idEstoque=" + idEstoque + ", quantidadeVelha=" + quantidadeVelha + ", quantidaAtual=" + quantidaAtual + '}';
    }
    
    
    
}
