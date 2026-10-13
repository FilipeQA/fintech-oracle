
package br.com.fiap.fintech.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL =
            "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";

    private static final String USUARIO = "RM567834";

    public static Connection getConnection() throws SQLException {

        String senha = System.getenv("FIAP_DB_PASSWORD");

        if (senha == null || senha.isBlank()) {
            throw new SQLException(
                    "Senha do Oracle nao configurada."
            );
        }

        return DriverManager.getConnection(
                URL, USUARIO, senha
        );
    }
}
