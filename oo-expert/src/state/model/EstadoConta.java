package state.model;

import strategy.investimentos.model.Conta;

public interface EstadoConta {

	double sacarValor(double valor);
	double depositarValor(double valor);
	void positivar(Conta conta);
	void negativar(Conta conta);
	String getDescricao();
}
