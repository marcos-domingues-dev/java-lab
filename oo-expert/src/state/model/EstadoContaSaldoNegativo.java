package state.model;

import strategy.investimentos.model.Conta;

public class EstadoContaSaldoNegativo implements EstadoConta {

	@Override
	public double sacarValor(double valor) {
		throw new RuntimeException("Saldo negativo não permite saque!;");
	}

	@Override
	public double depositarValor(double valor) {
		return valor * 0.95;
	}

	@Override
	public void positivar(Conta conta) {
		conta.alterarEstado(new EstadoContaSaldoPositivo());
	}

	@Override
	public void negativar(Conta conta) {
		throw new RuntimeException("Não é possível negativar uma conta negativa!");
	}

	@Override
	public String getDescricao() {
		return "Saldo negativo";
	}
}
