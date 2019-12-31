package strategy.investimentos.model;

public class Conta {
	private double saldo;
	private String titular;

	public Conta() {
		this.titular = "Unknown";
		this.saldo = 0;
	}

	public Conta(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldo = saldoInicial;
	}

	public String getTitular() {
		return titular;
	}

	public void depositar(double valorRendimento) {
		this.saldo += valorRendimento;
	}

	public void sacar(double valor) {
		this.saldo -= valor;
	}

	public double getSaldo() {
		return this.saldo;
	}
}
