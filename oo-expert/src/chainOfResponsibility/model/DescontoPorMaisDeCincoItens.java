package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public class DescontoPorMaisDeCincoItens implements Desconto {
	private Desconto proximo;

	@Override
	public double valorDesconto(Orcamento orcamento) {
		if (orcamento.getItens().size() >= 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return this.proximo.valorDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;
	}
}
