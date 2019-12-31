package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public interface Desconto {
	double valorDesconto(Orcamento orcamento);
	void setProximo(Desconto desconto);
}
