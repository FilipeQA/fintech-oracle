package br.com.fiap.fintech.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Conta {

    private int idConta;
    private BigDecimal saldo;
    private String tipoConta;
    private String statusConta;
    private LocalDate dataAbertura;
    private int idUsuario;

    public Conta(int idConta, BigDecimal saldo, String tipoConta,
                 String statusConta, LocalDate dataAbertura,
                 int idUsuario) {

        this.idConta = idConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.statusConta = statusConta;
        this.dataAbertura = dataAbertura;
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getStatusConta() {
        return statusConta;
    }

    public void setStatusConta(String statusConta) {
        this.statusConta = statusConta;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
