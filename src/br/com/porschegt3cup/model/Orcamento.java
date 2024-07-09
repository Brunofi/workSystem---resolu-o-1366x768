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
public class Orcamento {
    
    private int id;
    private String partNumber;
    private String nomePeca;
    private int quantidade;
    private String colaboradorEntrega;
    private String colaboradorPedido;
    private String motivoConsumo;
    private String etapa;
    private String sessao;
    private String chassis;
    private String eixoLado;
    private String NumeroMotorCambio;
    private String statusPeca;
    private String estadoPeca;
    private int quantidadeEstoque;
    private String locacoes;

    public Orcamento(int id, String partNumber, String nomePeca,int quantidade, String motivoConsumo, String chassis, String statusPeca, int quantidadeEstoque,String locacoes) {
        this.id = id;
        this.partNumber = partNumber;
        this.nomePeca = nomePeca;
        this.quantidade = quantidade;
        this.motivoConsumo = motivoConsumo;
        this.chassis = chassis;
        this.statusPeca = statusPeca;
        this.quantidadeEstoque = quantidadeEstoque;
        this.locacoes = locacoes;
    }
    
    
    

    public Orcamento(String partNumber, String nomePeca, int quantidade, String colaboradorPedido, String motivoConsumo, String etapa, String sessao, String chassis, String eixoLado, String NumeroMotorCambio, String statusPeca,String estadoPeca) {
        this.partNumber = partNumber;
        this.nomePeca = nomePeca;
        this.quantidade = quantidade;
        this.colaboradorPedido = colaboradorPedido;
        this.motivoConsumo = motivoConsumo;
        this.etapa = etapa;
        this.sessao = sessao;
        this.chassis = chassis;
        this.eixoLado = eixoLado;
        this.NumeroMotorCambio = NumeroMotorCambio;
        this.statusPeca = statusPeca;
        this.estadoPeca = estadoPeca;
        
    }

    public Orcamento() {
    }

    public Orcamento(int id) {
        this.id = id;
    }
    
    

    

    public String getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(String locacoes) {
        this.locacoes = locacoes;
    }
    
    

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    

    public String getEstadoPeca() {
        return estadoPeca;
    }

    public void setEstadoPeca(String estadoPeca) {
        this.estadoPeca = estadoPeca;
    }
    
    

    public String getStatusPeca() {
        return statusPeca;
    }

    public void setStatusPeca(String statusPeca) {
        this.statusPeca = statusPeca;
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

    public String getColaboradorEntrega() {
        return colaboradorEntrega;
    }

    public void setColaboradorEntrega(String colaboradorEntrega) {
        this.colaboradorEntrega = colaboradorEntrega;
    }

    public String getColaboradorPedido() {
        return colaboradorPedido;
    }

    public void setColaboradorPedido(String colaboradorPedido) {
        this.colaboradorPedido = colaboradorPedido;
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

    public String getEixoLado() {
        return eixoLado;
    }

    public void setEixoLado(String eixoLado) {
        this.eixoLado = eixoLado;
    }

    public String getNumeroMotorCambio() {
        return NumeroMotorCambio;
    }

    public void setNumeroMotorCambio(String NumeroMotorCambio) {
        this.NumeroMotorCambio = NumeroMotorCambio;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    @Override
    public String toString() {
        return "Orcamento{" + "id=" + id + ", partNumber=" + partNumber + ", nomePeca=" + nomePeca + ", quantidade=" + quantidade + ", colaboradorEntrega=" + colaboradorEntrega + ", colaboradorPedido=" + colaboradorPedido + ", motivoConsumo=" + motivoConsumo + ", etapa=" + etapa + ", sessao=" + sessao + ", chassis=" + chassis + ", eixoLado=" + eixoLado + ", NumeroMotorCambio=" + NumeroMotorCambio + ", statusPeca=" + statusPeca + ", estadoPeca=" + estadoPeca + ", quantidadeEstoque=" + quantidadeEstoque + ", locacoes=" + locacoes + '}';
    }

    
    
    
    
    
}
