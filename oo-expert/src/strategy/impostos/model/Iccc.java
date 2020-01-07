package strategy.impostos.model;

import decorator.model.ImpostoComposto;

public class Iccc extends ImpostoComposto {

	public Iccc() {
	}

	public Iccc(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double valor(Orcamento orcamento) {
		if (orcamento.getValor() < 1000) {
			return orcamento.getValor() * 0.05 + super.valorOutroImposto(orcamento);
		} else if (orcamento.getValor() <= 3000) {
			return orcamento.getValor() * 0.07 + super.valorOutroImposto(orcamento);
		} else {
			return (orcamento.getValor() * 0.08) + 30.0 + super.valorOutroImposto(orcamento);
		}
	}
}
