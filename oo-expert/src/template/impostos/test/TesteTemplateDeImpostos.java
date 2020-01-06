package template.impostos.test;

import java.text.NumberFormat;
import java.util.Locale;

import strategy.impostos.model.CalculadorDeImpostos;
import strategy.impostos.model.Imposto;
import strategy.impostos.model.Item;
import strategy.impostos.model.Orcamento;
import template.impostos.model.ImpostoX;
import template.impostos.model.ImpostoY;

public class TesteTemplateDeImpostos {

	public static void main(String[] args) {
		Imposto impostoX = new ImpostoX();
		Imposto impostoY = new ImpostoY();
		
		Item caneta = new Item("CANETA", 12.0);
		Item lapis = new Item("LAPIS", 0.5);
		
		Orcamento o = new Orcamento(500);
		o.adicionarItem(caneta);
		o.adicionarItem(lapis);
		
		NumberFormat formatadorDeNumeros = NumberFormat.getCurrencyInstance(new Locale("PT", "br"));
		CalculadorDeImpostos c = new CalculadorDeImpostos(formatadorDeNumeros);
		c.realizaCalculo(o, impostoX);
		c.realizaCalculo(o, impostoY);
	}
}
