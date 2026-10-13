
package br.com.fiap.fintech;

import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.model.Conta;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteConta {

    public static void main(String[] args) {

        ContaDAO contaDAO = new ContaDAO();

        try {

            // Cadastro de cinco contas ficticias
            contaDAO.insert(new Conta(
                    2001, new BigDecimal("1500.00"),
                    "CORRENTE", "ATIVA",
                    LocalDate.of(2026, 10, 13), 1001));

            contaDAO.insert(new Conta(
                    2002, new BigDecimal("2500.00"),
                    "POUPANCA", "ATIVA",
                    LocalDate.of(2026, 10, 13), 1002));

            contaDAO.insert(new Conta(
                    2003, new BigDecimal("3200.50"),
                    "CORRENTE", "ATIVA",
                    LocalDate.of(2026, 10, 13), 1003));

            contaDAO.insert(new Conta(
                    2004, new BigDecimal("4800.00"),
                    "POUPANCA", "ATIVA",
                    LocalDate.of(2026, 10, 13), 1004));

            contaDAO.insert(new Conta(
                    2005, new BigDecimal("5700.75"),
                    "CORRENTE", "ATIVA",
                    LocalDate.of(2026, 10, 13), 1005));

            // Consulta das contas cadastradas
            List<Conta> contas = contaDAO.getAll();

            System.out.println("\n=== CONTAS CADASTRADAS ===");

            for (Conta conta : contas) {
                System.out.println(
                        "ID: " + conta.getIdConta()
                                + " | Saldo: R$ " + conta.getSaldo()
                                + " | Tipo: " + conta.getTipoConta()
                                + " | Usuario: " + conta.getIdUsuario()
                );
            }

        } catch (SQLException e) {
            System.err.println(
                    "Erro no teste: " + e.getMessage()
            );
        }
    }
}
