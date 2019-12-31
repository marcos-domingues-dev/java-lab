package strategy.investimentos.model;

public class Conta {
	private double saldo;

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
