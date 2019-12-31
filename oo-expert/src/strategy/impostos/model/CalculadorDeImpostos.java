package strategy.impostos.model;

import java.text.NumberFormat;

public class CalculadorDeImpostos {
	private NumberFormat formatadorDeNumeros;

	public CalculadorDeImpostos(NumberFormat formatadorDeNumeros) {
		this.formatadorDeNumeros = formatadorDeNumeros;
	}

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valorImposto = imposto.valor(orcamento);
		String valorFormatado = formatadorDeNumeros.format(valorImposto);
		System.out.println(valorFormatado);
	}
}
