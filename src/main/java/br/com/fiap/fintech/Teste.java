
package br.com.fiap.fintech;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        try {

            // Cadastro de cinco usuarios ficticios
            usuarioDAO.insert(new Usuario(
                    1001, "Usuario Teste 1",
                    "teste1@example.com", "senhaTeste1",
                    "00000000001", "61999990001",
                    LocalDate.of(2000, 1, 10)));

            usuarioDAO.insert(new Usuario(
                    1002, "Usuario Teste 2",
                    "teste2@example.com", "senhaTeste2",
                    "00000000002", "61999990002",
                    LocalDate.of(1999, 2, 15)));

            usuarioDAO.insert(new Usuario(
                    1003, "Usuario Teste 3",
                    "teste3@example.com", "senhaTeste3",
                    "00000000003", "61999990003",
                    LocalDate.of(2001, 3, 20)));

            usuarioDAO.insert(new Usuario(
                    1004, "Usuario Teste 4",
                    "teste4@example.com", "senhaTeste4",
                    "00000000004", "61999990004",
                    LocalDate.of(1998, 4, 25)));

            usuarioDAO.insert(new Usuario(
                    1005, "Usuario Teste 5",
                    "teste5@example.com", "senhaTeste5",
                    "00000000005", "61999990005",
                    LocalDate.of(2002, 5, 30)));

            // Consulta dos usuarios cadastrados
            List<Usuario> usuarios = usuarioDAO.getAll();

            System.out.println("\n=== USUARIOS CADASTRADOS ===");

            for (Usuario usuario : usuarios) {
                System.out.println(
                        "ID: " + usuario.getIdUsuario()
                                + " | Nome: " + usuario.getNome()
                                + " | Email: " + usuario.getEmail()
                );
            }

        } catch (SQLException e) {
            System.err.println(
                    "Erro no teste: " + e.getMessage()
            );
        }
    }
}
