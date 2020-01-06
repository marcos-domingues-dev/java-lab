package template.impostos.model;

import strategy.impostos.model.Imposto;
import strategy.impostos.model.Orcamento;

public abstract class TemplateDeImpostoCondicional implements Imposto {

	/*
	 * Obs.: Utilizar o modificador "final" para evitar que o método seja
	 * sobrescrito em suas filhas!
	 */
	
	@Override
	public final double valor(Orcamento orcamento) {
		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);
	protected abstract double minimaTaxacao(Orcamento orcamento);
	protected abstract double maximaTaxacao(Orcamento orcamento);
}
