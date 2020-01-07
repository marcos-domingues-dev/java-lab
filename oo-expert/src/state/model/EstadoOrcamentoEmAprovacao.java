package state.model;

import strategy.impostos.model.Orcamento;

public class EstadoOrcamentoEmAprovacao implements EstadoDeUmOrcamento {
	private boolean descontoAplicado = false;

	@Override
	public void aplicarDescontoExtra(Orcamento orcamento) {
		if (!this.descontoAplicado) {
			double descontoExtra = orcamento.getValor() * 0.05;
			orcamento.aplicarDescontoExtra(descontoExtra);
			this.descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto já foi aplicado!");
		}
	}

	@Override
	public void aprovar(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoOrcamentoAprovado());
	}

	@Override
	public void reprovar(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoOrcamentoReprovado());
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Em Aprovação não pode ser finalizado!");
	}

}
