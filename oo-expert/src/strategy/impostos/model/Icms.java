package strategy.impostos.model;

import decorator.model.ImpostoComposto;

public class Icms extends ImpostoComposto {

	public Icms() {
	}

	public Icms(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double valor(Orcamento orcamento) {
		return orcamento.getValor() * 0.1 + super.valorOutroImposto(orcamento);
	}
}
