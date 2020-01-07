package state.model;

import strategy.investimentos.model.Conta;

public class EstadoContaSaldoPositivo implements EstadoConta {

	@Override
	public double sacarValor(double valor) {
		return valor;
	}

	@Override
	public double depositarValor(double valor) {
		return valor * 0.98;
	}

	@Override
	public void positivar(Conta conta) {
		throw new RuntimeException("Não é possível positivar uma conta positiva!");
	}

	@Override
	public void negativar(Conta conta) {
		conta.alterarEstado(new EstadoContaSaldoNegativo());
	}

	@Override
	public String getDescricao() {
		return "Saldo positivo";
	}
}
