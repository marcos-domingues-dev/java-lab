package strategy.impostos.model;

public class Iss implements Imposto {
	@Override
	public double valor(Orcamento orcamento) {
		return orcamento.getValor() * 0.06;
	}
}
