
package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Usuario;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public void insert(Usuario usuario) throws SQLException {

        String sql = "INSERT INTO Usuario " +
                "(id_usuario, nome, email, senha, cpf, " +
                "telefone, data_nascimento) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getTelefone());
            stmt.setDate(7, Date.valueOf(usuario.getDataNascimento()));

            stmt.executeUpdate();

            System.out.println("Usuario cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuario: "
                    + e.getMessage());
            throw e;
        }
    }


    public List<Usuario> getAll() throws SQLException {

        List<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM Usuario";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("cpf"),
                        rs.getString("telefone"),
                        rs.getDate("data_nascimento").toLocalDate()
                );

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar usuarios: "
                    + e.getMessage());
            throw e;
        }

        return usuarios;
    }
}
