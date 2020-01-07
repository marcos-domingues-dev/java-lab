package state.model;

import strategy.impostos.model.Orcamento;

public class EstadoOrcamentoFinalizado implements EstadoDeUmOrcamento {

	@Override
	public void aplicarDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos finalizados não podem receber desconto extra!");
	}

	@Override
	public void aprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Finalizado não pode ser Aprovado!");
		
	}

	@Override
	public void reprovar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Finalizado não pode ser Reprovado!");
		
	}

	@Override
	public void finalizar(Orcamento orcamento) {
		throw new RuntimeException("Orçamento Finalizado não pode ser Finalizado!");
		
	}

}
