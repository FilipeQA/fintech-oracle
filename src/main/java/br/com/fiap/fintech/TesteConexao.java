package br.com.fiap.fintech;

import br.com.fiap.fintech.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {

        try (Connection conexao = ConnectionFactory.getConnection()) {

            System.out.println(
                    "Conexao com Oracle FIAP realizada com sucesso!"
            );

        } catch (SQLException e) {

            System.err.println(
                    "Erro na conexao: " + e.getMessage()
            );
        }
    }
}
