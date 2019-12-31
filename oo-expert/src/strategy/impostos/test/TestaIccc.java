package strategy.impostos.test;

import java.text.NumberFormat;
import java.util.Locale;

import strategy.impostos.model.CalculadorDeImpostos;
import strategy.impostos.model.Iccc;
import strategy.impostos.model.Imposto;
import strategy.impostos.model.Orcamento;

public class TestaIccc {

	public static void main(String[] args) {
		Orcamento orcamento1 = new Orcamento(1000);
		Orcamento orcamento2 = new Orcamento(3000);
		Orcamento orcamento3 = new Orcamento(10000);

		Imposto iccc = new Iccc();				
		NumberFormat formatadorDeNumeros = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos(formatadorDeNumeros);
		calculadorDeImpostos.realizaCalculo(orcamento1, iccc);
		calculadorDeImpostos.realizaCalculo(orcamento2, iccc);
		calculadorDeImpostos.realizaCalculo(orcamento3, iccc);
		
	}
}
