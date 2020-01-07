package strategy.investimentos.model;

import state.model.EstadoConta;
import state.model.EstadoContaSaldoNegativo;
import state.model.EstadoContaSaldoPositivo;

public class Conta {
	private double saldo;
	private String titular;
	private String numero;
	private String agencia;
	private EstadoConta estadoAtual;

	public Conta() {
		this.titular = "Unknown";
		this.saldo = 0;
		this.configurarEstadoInicial();
	}

	private void configurarEstadoInicial() {
		if (this.saldo < 0) {
			this.estadoAtual = new EstadoContaSaldoNegativo();
		} else {
			this.estadoAtual = new EstadoContaSaldoPositivo();
		}
	}

	public Conta(String titular, double saldoInicial) {
		this.titular = titular;
		this.saldo = saldoInicial;
		this.configurarEstadoInicial();
	}

	public void depositar(double valor) {
		this.saldo += this.estadoAtual.depositarValor(valor);

		if (this.estadoAtual instanceof EstadoContaSaldoNegativo && this.saldo >= 0) {
			estadoAtual.positivar(this);
		}
	}

	public void sacar(double valor) {
		this.saldo -= this.estadoAtual.sacarValor(valor);

		if (this.estadoAtual instanceof EstadoContaSaldoPositivo && this.saldo < 0) {
			estadoAtual.negativar(this);
		}
	}

	public double getSaldo() {
		return this.saldo;
	}

	public void alterarEstado(EstadoConta estadoConta) {
		this.estadoAtual = estadoConta;
	}

	@Override
	public String toString() {
		return "Titular: " + this.titular + " - " + "Conta:" + this.agencia + "/" + this.numero + "Saldo: "
				+ this.saldo + " - " +
				"Estado: " + this.estadoAtual.getDescricao();
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

	public String getTitular() {
		return titular;
	}
}
