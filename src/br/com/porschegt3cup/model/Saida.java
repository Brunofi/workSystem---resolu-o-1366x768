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
public class Saida {
    
    private int id;
    private int quantidadeSaida;
    private String tipoMovimentacao;
    private String colaboradorEntrega;
    private String colaboradorRetira;
    private String colaboradorLanca;
    private String motivoConsumo;
    private String etapa;
    private String sessao;
    private String chassis;
    private String chassisCedente;
    private String eixoLado;
    private int idPeca;
    private int idLocacao;

    public Saida(int quantidadeSaida, String tipoMovimentacao, String colaboradorEntrega, String colaboradorRetira, String colaboradorLanca, String motivoConsumo, String etapa, String sessao, String chassis, String chassisCedente, String eixoLado, int idPeca, int idLocacao) {
        this.quantidadeSaida = quantidadeSaida;
        this.tipoMovimentacao = tipoMovimentacao;
        this.colaboradorEntrega = colaboradorEntrega;
        this.colaboradorRetira = colaboradorRetira;
        this.colaboradorLanca = colaboradorLanca;
        this.motivoConsumo = motivoConsumo;
        this.etapa = etapa;
        this.sessao = sessao;
        this.chassis = chassis;
        this.chassisCedente = chassisCedente;
        this.eixoLado = eixoLado;
        this.idPeca = idPeca;
        this.idLocacao = idLocacao;
    }

    public Saida() {
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidadeSaida() {
        return quantidadeSaida;
    }

    public void setQuantidadeSaida(int quantidadeSaida) {
        this.quantidadeSaida = quantidadeSaida;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getColaboradorEntrega() {
        return colaboradorEntrega;
    }

    public void setColaboradorEntrega(String colaboradorEntrega) {
        this.colaboradorEntrega = colaboradorEntrega;
    }

    public String getColaboradorRetira() {
        return colaboradorRetira;
    }

    public void setColaboradorRetira(String colaboradorRetira) {
        this.colaboradorRetira = colaboradorRetira;
    }

    public String getColaboradorLanca() {
        return colaboradorLanca;
    }

    public void setColaboradorLanca(String colaboradorLanca) {
        this.colaboradorLanca = colaboradorLanca;
    }

    public String getMotivoConsumo() {
        return motivoConsumo;
    }

    public void setMotivoConsumo(String motivoConsumo) {
        this.motivoConsumo = motivoConsumo;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getChassisCedente() {
        return chassisCedente;
    }

    public void setChassisCedente(String chassisCedente) {
        this.chassisCedente = chassisCedente;
    }

    public String getEixoLado() {
        return eixoLado;
    }

    public void setEixoLado(String eixoLado) {
        this.eixoLado = eixoLado;
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
        return "Saida{" + "id=" + id + ", quantidadeSaida=" + quantidadeSaida + ", tipoMovimentacao=" + tipoMovimentacao + ", colaboradorEntrega=" + colaboradorEntrega + ", colaboradorRetira=" + colaboradorRetira + ", colaboradorLanca=" + colaboradorLanca + ", motivoConsumo=" + motivoConsumo + ", etapa=" + etapa + ", sessao=" + sessao + ", chassis=" + chassis + ", chassisCedente=" + chassisCedente + ", eixoLado=" + eixoLado + ", idPeca=" + idPeca + ", idLocacao=" + idLocacao + '}';
    }
    
    
    
}
