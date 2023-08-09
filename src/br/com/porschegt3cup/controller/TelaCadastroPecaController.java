/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.controller;

import br.com.porschegt3cup.view.TelaCadastroPeca;
import java.sql.Connection;

/**
 *
 * @author bruno
 */
public class TelaCadastroPecaController {
    Connection conexao = null;
    private TelaCadastroPeca telaCadastroPeca;

    public TelaCadastroPecaController(TelaCadastroPeca telaCadastroPeca) {
        this.telaCadastroPeca = telaCadastroPeca;
    }
    
    
    
}
