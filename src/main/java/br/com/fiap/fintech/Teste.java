
package br.com.fiap.fintech;

import br.com.fiap.fintech.dao.UsuarioDAO;
import br.com.fiap.fintech.dao.ContaDAO;
import br.com.fiap.fintech.dao.InvestimentoDAO;

import br.com.fiap.fintech.model.Usuario;
import br.com.fiap.fintech.model.Conta;
import br.com.fiap.fintech.model.Investimento;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Teste {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ContaDAO contaDAO = new ContaDAO();
        InvestimentoDAO investimentoDAO = new InvestimentoDAO();

        try {

            // ========================================
            // 1. CADASTRO DE USUARIOS
            // ========================================

            System.out.println("=== CADASTRO DE USUARIOS ===");

            List<Usuario> novosUsuarios = List.of(
                    new Usuario(1001, "Usuario Teste 1",
                            "teste1@example.com", "senhaTeste1",
                            "00000000001", "61999990001",
                            LocalDate.of(2000, 1, 10)),

                    new Usuario(1002, "Usuario Teste 2",
                            "teste2@example.com", "senhaTeste2",
                            "00000000002", "61999990002",
                            LocalDate.of(1999, 2, 15)),

                    new Usuario(1003, "Usuario Teste 3",
                            "teste3@example.com", "senhaTeste3",
                            "00000000003", "61999990003",
                            LocalDate.of(2001, 3, 20)),

                    new Usuario(1004, "Usuario Teste 4",
                            "teste4@example.com", "senhaTeste4",
                            "00000000004", "61999990004",
                            LocalDate.of(1998, 4, 25)),

                    new Usuario(1005, "Usuario Teste 5",
                            "teste5@example.com", "senhaTeste5",
                            "00000000005", "61999990005",
                            LocalDate.of(2002, 5, 30))
            );

            List<Usuario> usuariosExistentes = usuarioDAO.getAll();

            for (Usuario usuario : novosUsuarios) {

                boolean existe = usuariosExistentes.stream()
                        .anyMatch(u -> u.getIdUsuario() == usuario.getIdUsuario());

                if (!existe) {
                    usuarioDAO.insert(usuario);
                } else {
                    System.out.println(
                            "Usuario " + usuario.getIdUsuario() + " ja cadastrado."
                    );
                }
            }

            // ========================================
            // 2. CADASTRO DE CONTAS
            // ========================================

            System.out.println("\n=== CADASTRO DE CONTAS ===");

            List<Conta> novasContas = List.of(
                    new Conta(2001, new BigDecimal("1500.00"),
                            "CORRENTE", "ATIVA",
                            LocalDate.of(2026, 10, 13), 1001),

                    new Conta(2002, new BigDecimal("2500.00"),
                            "POUPANCA", "ATIVA",
                            LocalDate.of(2026, 10, 13), 1002),

                    new Conta(2003, new BigDecimal("3200.50"),
                            "CORRENTE", "ATIVA",
                            LocalDate.of(2026, 10, 13), 1003),

                    new Conta(2004, new BigDecimal("4800.00"),
                            "POUPANCA", "ATIVA",
                            LocalDate.of(2026, 10, 13), 1004),

                    new Conta(2005, new BigDecimal("5700.75"),
                            "CORRENTE", "ATIVA",
                            LocalDate.of(2026, 10, 13), 1005)
            );

            List<Conta> contasExistentes = contaDAO.getAll();

            for (Conta conta : novasContas) {

                boolean existe = contasExistentes.stream()
                        .anyMatch(c -> c.getIdConta() == conta.getIdConta());

                if (!existe) {
                    contaDAO.insert(conta);
                } else {
                    System.out.println(
                            "Conta " + conta.getIdConta() + " ja cadastrada."
                    );
                }
            }

            // ========================================
            // 3. CADASTRO DE INVESTIMENTOS
            // ========================================

            System.out.println("\n=== CADASTRO DE INVESTIMENTOS ===");

            List<Investimento> novosInvestimentos = List.of(
                    new Investimento(3001, "CDB",
                            new BigDecimal("1000.00"),
                            new BigDecimal("1.20"),
                            LocalDate.of(2026, 10, 13), 2001),

                    new Investimento(3002, "TESOURO DIRETO",
                            new BigDecimal("2000.00"),
                            new BigDecimal("1.50"),
                            LocalDate.of(2026, 10, 13), 2002),

                    new Investimento(3003, "LCI",
                            new BigDecimal("1500.00"),
                            new BigDecimal("1.10"),
                            LocalDate.of(2026, 10, 13), 2003),

                    new Investimento(3004, "LCA",
                            new BigDecimal("3000.00"),
                            new BigDecimal("1.30"),
                            LocalDate.of(2026, 10, 13), 2004),

                    new Investimento(3005, "FUNDO DE INVESTIMENTO",
                            new BigDecimal("2500.00"),
                            new BigDecimal("2.00"),
                            LocalDate.of(2026, 10, 13), 2005)
            );

            List<Investimento> investimentosExistentes =
                    investimentoDAO.getAll();

            for (Investimento investimento : novosInvestimentos) {

                boolean existe = investimentosExistentes.stream()
                        .anyMatch(i -> i.getIdInvestimento()
                                == investimento.getIdInvestimento());

                if (!existe) {
                    investimentoDAO.insert(investimento);
                } else {
                    System.out.println(
                            "Investimento " + investimento.getIdInvestimento()
                                    + " ja cadastrado."
                    );
                }
            }

            // ========================================
            // 4. CONSULTA DE USUARIOS
            // ========================================

            System.out.println("\n=== USUARIOS CADASTRADOS ===");

            List<Usuario> usuarios = usuarioDAO.getAll();

            for (Usuario usuario : usuarios) {
                System.out.println(
                        "ID: " + usuario.getIdUsuario()
                                + " | Nome: " + usuario.getNome()
                                + " | Email: " + usuario.getEmail()
                );
            }

            // ========================================
            // 5. CONSULTA DE CONTAS
            // ========================================

            System.out.println("\n=== CONTAS CADASTRADAS ===");

            List<Conta> contas = contaDAO.getAll();

            for (Conta conta : contas) {
                System.out.println(
                        "ID: " + conta.getIdConta()
                                + " | Saldo: R$ " + conta.getSaldo()
                                + " | Tipo: " + conta.getTipoConta()
                                + " | Usuario: " + conta.getIdUsuario()
                );
            }

            // ========================================
            // 6. CONSULTA DE INVESTIMENTOS
            // ========================================

            System.out.println("\n=== INVESTIMENTOS CADASTRADOS ===");

            List<Investimento> investimentos = investimentoDAO.getAll();

            for (Investimento investimento : investimentos) {
                System.out.println(
                        "ID: " + investimento.getIdInvestimento()
                                + " | Tipo: " + investimento.getTipoInvestimento()
                                + " | Valor: R$ " + investimento.getValorInvestido()
                                + " | Rendimento: " + investimento.getRendimento()
                                + " | Conta: " + investimento.getIdConta()
                );
            }

            // ========================================
            // 7. RESUMO DOS TESTES
            // ========================================

            System.out.println("\n=== TESTES FINALIZADOS ===");
            System.out.println("Usuarios encontrados: " + usuarios.size());
            System.out.println("Contas encontradas: " + contas.size());
            System.out.println("Investimentos encontrados: "
                    + investimentos.size());

        } catch (SQLException e) {
            System.err.println("Erro ao executar os testes: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }
}
