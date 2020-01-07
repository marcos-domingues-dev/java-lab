package state.model;

import strategy.impostos.model.Orcamento;

public class EstadoOrcamentoAprovado implements EstadoDeUmOrcamento {
	private boolean descontoAplicado = false;

	@Override
	public void aplicarDescontoExtra(Orcamento orcamento) {
		if (!this.descontoAplicado) {
			double descontoExtra = orcamento.getValor() * 0.02;
			orcamento.aplicarDescontoExtra(descontoExtra);
			this.descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto já foi aplicado!");
		}
	}

	@Override
	public void aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos Aprovados não podem ser Aprovados!");
	}

	@Override
	public void reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos Aprovados não podem ser Reprovados!");
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoOrcamentoFinalizado());
	}
}
