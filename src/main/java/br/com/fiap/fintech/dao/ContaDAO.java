package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Conta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {

    public void insert(Conta conta) throws SQLException {

        String sql = "INSERT INTO Conta " +
                "(id_conta, saldo, tipo_conta, status_conta, " +
                "data_abertura, Usuario_id_usuario) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, conta.getIdConta());
            stmt.setBigDecimal(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setString(4, conta.getStatusConta());
            stmt.setDate(5, Date.valueOf(conta.getDataAbertura()));
            stmt.setInt(6, conta.getIdUsuario());

            stmt.executeUpdate();

            System.out.println("Conta cadastrada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar conta: "
                    + e.getMessage());
            throw e;
        }
    }

    public List<Conta> getAll() throws SQLException {

        List<Conta> contas = new ArrayList<>();

        String sql = "SELECT * FROM Conta";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Conta conta = new Conta(
                        rs.getInt("id_conta"),
                        rs.getBigDecimal("saldo"),
                        rs.getString("tipo_conta"),
                        rs.getString("status_conta"),
                        rs.getDate("data_abertura").toLocalDate(),
                        rs.getInt("Usuario_id_usuario")
                );

                contas.add(conta);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar contas: "
                    + e.getMessage());
            throw e;
        }

        return contas;
    }
}
