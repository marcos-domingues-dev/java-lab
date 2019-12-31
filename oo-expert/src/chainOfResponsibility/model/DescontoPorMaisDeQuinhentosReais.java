package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public class DescontoPorMaisDeQuinhentosReais implements Desconto {
	private Desconto proximo;

	@Override
	public double valorDesconto(Orcamento orcamento) {
		if (orcamento.getValor() > 500) {
			return orcamento.getValor() * 0.07;
		} else {
			return proximo.valorDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}
}
