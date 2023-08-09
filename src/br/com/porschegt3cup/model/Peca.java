/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.model;

import java.math.BigDecimal;

/**
 *
 * @author bruno
 */
public class Peca {

    private int id;
    private String nome;
    private String partNumber;
    private String peso;
    private String ncm;
    private String estado;
    private String modeloCarro;
    private String subSistema;
    private String fabricante;
    private int qtdMin;
    private int qtdMed;
    private int qtdMax;
    private BigDecimal preco;
    private String partNumberSimilar;

    public Peca(int id) {
        this.id = id;
    }

    public Peca(int id, String nome, String partNumber, String peso, String ncm, String estado, String modelocarro, String subsistema, String fabricante, int qtdmin, int qtdmed, int qtdmax, BigDecimal preco, String partNumberSimilar) {
        this.id = id;
        this.nome = nome;
        this.partNumber = partNumber;
        this.peso = peso;
        this.ncm = ncm;
        this.estado = estado;
        this.modeloCarro = modelocarro;
        this.subSistema = subsistema;
        this.fabricante = fabricante;
        this.qtdMin = qtdmin;
        this.qtdMed = qtdmed;
        this.qtdMax = qtdmax;
        this.preco = preco;
        this.partNumberSimilar = partNumberSimilar;
    }

    public Peca() {
    }

    public Peca(String partNumberOuNome) {
        this.partNumber = partNumberOuNome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getNcm() {
        return ncm;
    }

    public void setNcm(String ncm) {
        this.ncm = ncm;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getSubSistema() {
        return subSistema;
    }

    public void setSubSistema(String subSistema) {
        this.subSistema = subSistema;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getQtdMin() {
        return qtdMin;
    }

    public void setQtdMin(int qtdMin) {
        this.qtdMin = qtdMin;
    }

    public int getQtdMed() {
        return qtdMed;
    }

    public void setQtdMed(int qtdMed) {
        this.qtdMed = qtdMed;
    }

    public int getQtdMax() {
        return qtdMax;
    }

    public void setQtdMax(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getPartNumberSimilar() {
        return partNumberSimilar;
    }

    public void setPartNumberSimilar(String partNumberSimilar) {
        this.partNumberSimilar = partNumberSimilar;
    }
    
    

}
