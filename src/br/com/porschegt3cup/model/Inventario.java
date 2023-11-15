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
    private int quantidadeAtual;
    private String nomeColaborador;
    

    

    public Inventario() {
    }

    public Inventario(int idEstoque, int quantidadeVelha, int quantidaAtual, String nomeColaborador) {
        this.idEstoque = idEstoque;
        this.quantidadeVelha = quantidadeVelha;
        this.quantidadeAtual = quantidaAtual;
        this.nomeColaborador = nomeColaborador;
    }
    
    

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
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

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    @Override
    public String toString() {
        return "Inventario{" + "id=" + id + ", idEstoque=" + idEstoque + ", quantidadeVelha=" + quantidadeVelha + ", quantidaAtual=" + quantidadeAtual + '}';
    }
    
    
    
}
