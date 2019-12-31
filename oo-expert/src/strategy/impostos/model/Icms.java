package strategy.impostos.model;

public class Icms implements Imposto {
	@Override
	public double valor(Orcamento orcamento) {
		return orcamento.getValor() * 0.1;
	}
}
