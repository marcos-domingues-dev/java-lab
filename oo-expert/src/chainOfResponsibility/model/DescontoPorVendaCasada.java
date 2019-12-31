package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public class DescontoPorVendaCasada implements Desconto {
	private Desconto proximo;

	@Override
	public double valorDesconto(Orcamento orcamento) {
		if (orcamento.contemItemDeNome("LAPIS") || orcamento.contemItemDeNome("CANETA")) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.valorDesconto(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		this.proximo = desconto;

	}

}
