package strategy.investimentos.model;

public class Conta {
	private double saldo;
	private String titular;
	private String numero;
	private String agencia;

	
	@Override
	public String toString() {
		return "Titular: " + this.titular + " - " +
				"Conta:" + this.agencia + "/" + this.numero +
				"Saldo: " + this.saldo;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

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
