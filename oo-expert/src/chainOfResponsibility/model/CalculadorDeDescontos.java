package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public class CalculadorDeDescontos {
	public double valorDesconto(Orcamento orcamento, Desconto desconto) {
		return desconto.valorDesconto(orcamento);
	}

}
