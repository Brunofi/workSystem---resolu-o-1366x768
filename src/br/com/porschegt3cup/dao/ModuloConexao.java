/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import java.sql.*;

/**
 *
 * @author bruno
 */
public class ModuloConexao {

    // método para estabelecer conexão
    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver"; // driver do banco utilizado
        
        String url = System.getenv("DB_URL"); 
        String usuario = System.getenv("DB_USERNAME");
        String senha = System.getenv("DB_PASSWORD");
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
