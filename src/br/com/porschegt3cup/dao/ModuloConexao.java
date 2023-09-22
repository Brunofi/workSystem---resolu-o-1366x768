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

    //metodo para estabelecer conexão
    public static Connection conector() {
        Connection conexao = null;
        String driver = "com.mysql.cj.jdbc.Driver"; //driver do banco utilizado
        String url = "jdbc:mysql://10.10.183.202:3306/porschegt3cup"; //caminho do banco
        String usuario = "root";
        String senha = "bsdnadmin";

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao;
        } catch (Exception e) {

            return null;

        }

    }

}
