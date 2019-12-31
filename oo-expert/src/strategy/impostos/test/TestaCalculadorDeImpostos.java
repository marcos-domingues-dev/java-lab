package strategy.impostos.test;

import java.text.NumberFormat;
import java.util.Locale;

import strategy.impostos.model.CalculadorDeImpostos;
import strategy.impostos.model.Icms;
import strategy.impostos.model.Imposto;
import strategy.impostos.model.Iss;
import strategy.impostos.model.Orcamento;

public class TestaCalculadorDeImpostos {
	
	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento(1000);
		Imposto icms = new Icms();
		Imposto iss = new Iss();
				
		NumberFormat formatadorDeNumeros = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		CalculadorDeImpostos calculadorDeImpostos = new CalculadorDeImpostos(formatadorDeNumeros);
		calculadorDeImpostos.realizaCalculo(orcamento, icms);
		calculadorDeImpostos.realizaCalculo(orcamento, iss);
		
		/* Strategy pattern: 
		 * -> Quando um único método pode realizar diferentes 
		 * tipos de implementações, recebendo a estratégia;
		 * -> A abstração permite o polimorfismo;
		 * -> Implementa uma interface para realizar 
		 * cada serviço de cálculo de imposto;
		 * -> A criação de novos impostos não altera o código 
		 * que existe! */
	}
}
