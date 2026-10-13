
package br.com.fiap.fintech.dao;

import br.com.fiap.fintech.factory.ConnectionFactory;
import br.com.fiap.fintech.model.Investimento;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvestimentoDAO {

    public void insert(Investimento investimento) throws SQLException {

        String sql = "INSERT INTO Investimento " +
                "(id_investimento, tipo_investimento, " +
                "valor_investido, rendimento, data_aplicacao, " +
                "Conta_id_conta) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, investimento.getIdInvestimento());
            stmt.setString(2, investimento.getTipoInvestimento());
            stmt.setBigDecimal(3, investimento.getValorInvestido());
            stmt.setBigDecimal(4, investimento.getRendimento());
            stmt.setDate(5, Date.valueOf(investimento.getDataAplicacao()));
            stmt.setInt(6, investimento.getIdConta());

            stmt.executeUpdate();

            System.out.println("Investimento cadastrado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar investimento: "
                    + e.getMessage());
            throw e;
        }
    }

    public List<Investimento> getAll() throws SQLException {

        List<Investimento> investimentos = new ArrayList<>();

        String sql = "SELECT * FROM Investimento";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Investimento investimento = new Investimento(
                        rs.getInt("id_investimento"),
                        rs.getString("tipo_investimento"),
                        rs.getBigDecimal("valor_investido"),
                        rs.getBigDecimal("rendimento"),
                        rs.getDate("data_aplicacao").toLocalDate(),
                        rs.getInt("Conta_id_conta")
                );

                investimentos.add(investimento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao consultar investimentos: "
                    + e.getMessage());
            throw e;
        }

        return investimentos;
    }
}
