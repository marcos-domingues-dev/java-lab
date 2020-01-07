package strategy.impostos.model;

import decorator.model.ImpostoComposto;

public class Iss extends ImpostoComposto {

	public Iss() {
	}

	public Iss(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double valor(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + super.valorOutroImposto(orcamento);
	}
}
