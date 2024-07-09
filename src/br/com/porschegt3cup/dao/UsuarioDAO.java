/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.porschegt3cup.dao;

import br.com.porschegt3cup.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bruno
 */
public class UsuarioDAO {

    private final Connection conexao;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UsuarioDAO(Connection connection) {
        this.conexao = connection;
    }

    public boolean logar(Usuario usuario) {
        String sql = "select * from tbusuarios where login=? and senha =?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            rs = pst.executeQuery();

            //se obter resultado a variavel "rs" retorna true
            return rs.next();

        } catch (Exception e) {

            return false;

        }
    }

    public String decubrirPerfil(Usuario usuario) {

        try {
            String sql = "select * from tbusuarios where login=?";

            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            rs = pst.executeQuery();

            if (rs.next()) {
                String perfil = rs.getString(5);
                return perfil;

            } else {
                return "Perfil não encontrado";

            }

        } catch (Exception e) {

            e.printStackTrace();
            return "nada";

        }

    }

    public void InserirUsuario(Usuario usuario) {
        String sql = "insert into tbusuarios (nome,login,senha,perfil) values(?,?,?,?)";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getPerfil());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void alterarUsuario(Usuario usuario) {
        String sql = "update tbusuarios set nome=?,login=?,senha=?,perfil=? where id=? ";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getLogin());
            pst.setString(3, usuario.getSenha());
            pst.setString(4, usuario.getPerfil());
            pst.setInt(5, usuario.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void removerUsuario(int id) {
        String sql = "delete from tbusuarios where id=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public Usuario buscarUsuarioPorId(Usuario usuario) {

        try {
            String sql = "select * from tbusuarios where id=?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, usuario.getId());
            rs = pst.executeQuery();
            if (rs.next()) {
                int idUsuario = Integer.parseInt(rs.getString(1));
                usuario.setId(idUsuario);
                usuario.setNome(rs.getString(2));
                usuario.setLogin(rs.getString(3));
                usuario.setSenha(rs.getString(4));
                usuario.setPerfil(rs.getString(5));

                return usuario;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Não encontrado");
                return null;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        return null;

    }

    public String retornarSenha(int id) {
        try {
            String sql = "select * from tbusuarios where id=?";
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                String senha = rs.getString(4);
                return senha;
            } else {
                JOptionPane.showMessageDialog(null, "Problema ao captar a senha");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            
        }
        return null;

    }

    public Usuario buscarUsuarioPorLogin(Usuario usuario) {

        try {
            String sql = "select * from tbusuarios where login=?";
            pst = conexao.prepareStatement(sql);
            pst.setString(1, usuario.getLogin());
            rs = pst.executeQuery();

            if (rs.next()) {

                usuario.setId(rs.getInt(1));
                usuario.setNome(rs.getString(2));
                usuario.setLogin(rs.getString(3));
                usuario.setSenha(rs.getString(4));
                usuario.setPerfil(rs.getString(5));

                return usuario;
            } else {
                JOptionPane.showMessageDialog(null, "Usuario Não encontrado");

                return null;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
        }
        return null;

    }

    public boolean verificarConexao() {
        try {
            return !conexao.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet buscarUsuarioPorNome(String nome) {
        String sql = "select id as ID,login as LOGIN, nome as NOME, perfil as PERFIL from  tbusuarios where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, nome + "%");
            rs = pst.executeQuery();
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "Usuario não encontrada");
                return null;
            }

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
