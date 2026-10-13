package br.com.fiap.fintech.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Investimento {

    private int idInvestimento;
    private String tipoInvestimento;
    private BigDecimal valorInvestido;
    private BigDecimal rendimento;
    private LocalDate dataAplicacao;
    private int idConta;

    public Investimento(int idInvestimento, String tipoInvestimento, BigDecimal valorInvestido, BigDecimal rendimento, LocalDate dataAplicacao, int idConta) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestido = valorInvestido;
        this.rendimento = rendimento;
        this.dataAplicacao = dataAplicacao;
        this.idConta = idConta;
    }

    public int getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(int idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public BigDecimal getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(BigDecimal valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

    public BigDecimal getRendimento() {
        return rendimento;
    }

    public void setRendimento(BigDecimal rendimento) {
        this.rendimento = rendimento;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
