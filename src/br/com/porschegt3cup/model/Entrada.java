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
public class Entrada {
    private int id;
    private int quantidadeEntrada;
    private String motivo;
    private String colaborador;
    private String observacao;
    private int idPeca;
    private int idLocacao;

    public Entrada() {
    }

    public Entrada(int id, int quantidadeEntrada, String motivo, String colaborador, String observacao, int idPeca, int idLocacao) {
        this.id = id;
        this.quantidadeEntrada = quantidadeEntrada;
        this.motivo = motivo;
        this.colaborador = colaborador;
        this.observacao = observacao;
        this.idPeca = idPeca;
        this.idLocacao = idLocacao;
    }

    public Entrada(int quantidadeEntrada, String motivo, String colaborador, String observacao, int idPeca, int idLocacao) {
        this.quantidadeEntrada = quantidadeEntrada;
        this.motivo = motivo;
        this.colaborador = colaborador;
        this.observacao = observacao;
        this.idPeca = idPeca;
        this.idLocacao = idLocacao;
    }
    
    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeEntrada() {
        return quantidadeEntrada;
    }

    public void setQuantidadeEntrada(int quantidadeEntrada) {
        this.quantidadeEntrada = quantidadeEntrada;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        return "Entrada{" + "id=" + id + ", quantidadeEntrada=" + quantidadeEntrada + ", motivo=" + motivo + ", colaborador=" + colaborador + ", observacao=" + observacao + ", idPeca=" + idPeca + ", idLocacao=" + idLocacao + '}';
    }
    
    
    
    
    
}
