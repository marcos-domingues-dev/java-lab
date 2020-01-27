package lsp_inheritance.model;

public class ManipuladorDeSaldo {
    private double saldo;

    public ManipuladorDeSaldo() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(final double valor) {
        this.saldo += valor;
    }

    public void sacar(final double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    public void render() {
        this.saldo += this.saldo * 0.01;
    }
}