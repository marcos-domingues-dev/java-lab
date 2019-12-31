package chainOfResponsibility.model;

import strategy.impostos.model.Orcamento;

public class DescontoZerado implements Desconto {

	@Override
	public double valorDesconto(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto desconto) {
		// Nothing TODO
	}
}
