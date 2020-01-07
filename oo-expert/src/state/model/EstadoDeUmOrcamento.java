package state.model;

import strategy.impostos.model.Orcamento;

public interface EstadoDeUmOrcamento {
	
	void aplicarDescontoExtra(Orcamento orcamento);

	void aprovar(Orcamento orcamento);
	void reprovar(Orcamento orcamento);
	void finalizar(Orcamento orcamento);
}
