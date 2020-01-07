package state.model;

import strategy.impostos.model.Orcamento;

public class EstadoOrcamentoReprovado implements EstadoDeUmOrcamento {

	@Override
	public void aplicarDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos reprovados não podem receber desconto extra!");
	}

	@Override
	public void aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Reprovado não pode ser aprovado!");
	}
	
	@Override
	public void reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Reprovado não pode ser Reprovado!");
		
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		orcamento.setEstadoAtual(new EstadoOrcamentoFinalizado());		
	}

}
