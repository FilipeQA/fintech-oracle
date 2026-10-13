
package br.com.fiap.fintech;

import br.com.fiap.fintech.dao.InvestimentoDAO;
import br.com.fiap.fintech.model.Investimento;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class TesteInvestimento {

    public static void main(String[] args) {

        InvestimentoDAO investimentoDAO = new InvestimentoDAO();

        try {

            // Cadastro de cinco investimentos ficticios
            investimentoDAO.insert(new Investimento(
                    3001, "CDB",
                    new BigDecimal("1000.00"),
                    new BigDecimal("1.20"),
                    LocalDate.of(2026, 10, 13), 2001));

            investimentoDAO.insert(new Investimento(
                    3002, "TESOURO DIRETO",
                    new BigDecimal("2000.00"),
                    new BigDecimal("1.50"),
                    LocalDate.of(2026, 10, 13), 2002));

            investimentoDAO.insert(new Investimento(
                    3003, "LCI",
                    new BigDecimal("1500.00"),
                    new BigDecimal("1.10"),
                    LocalDate.of(2026, 10, 13), 2003));

            investimentoDAO.insert(new Investimento(
                    3004, "LCA",
                    new BigDecimal("3000.00"),
                    new BigDecimal("1.30"),
                    LocalDate.of(2026, 10, 13), 2004));

            investimentoDAO.insert(new Investimento(
                    3005, "FUNDO DE INVESTIMENTO",
                    new BigDecimal("2500.00"),
                    new BigDecimal("2.00"),
                    LocalDate.of(2026, 10, 13), 2005));

            // Consulta dos investimentos cadastrados
            List<Investimento> investimentos =
                    investimentoDAO.getAll();

            System.out.println(
                    "\n=== INVESTIMENTOS CADASTRADOS ==="
            );

            for (Investimento investimento : investimentos) {
                System.out.println(
                        "ID: " + investimento.getIdInvestimento()
                                + " | Tipo: " + investimento.getTipoInvestimento()
                                + " | Valor: R$ " + investimento.getValorInvestido()
                                + " | Rendimento: " + investimento.getRendimento()
                                + " | Conta: " + investimento.getIdConta()
                );
            }

        } catch (SQLException e) {
            System.err.println(
                    "Erro no teste: " + e.getMessage()
            );
        }
    }
}
