package decorator.model;

import strategy.impostos.model.Imposto;
import strategy.impostos.model.Orcamento;

public abstract class ImpostoComposto implements Imposto {

	protected final Imposto outroImposto;

	public ImpostoComposto() {
		this.outroImposto = null;
	}

	public ImpostoComposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	@Override
	public double valor(Orcamento orcamento) {
		return 0;
	}

	public double valorOutroImposto(Orcamento orcamento) {
		// return (this.outroImposto == null) ? 0 : this.outroImposto.valor(orcamento);

		if (this.outroImposto == null) {
			return 0;
		} else {
			return this.outroImposto.valor(orcamento);
		}
	}

}
