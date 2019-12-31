package chainOfResponsibility.test;

import chainOfResponsibility.model.CalculadorDeDescontos;
import chainOfResponsibility.model.Desconto;
import chainOfResponsibility.model.FabricaDaCorrenteDeDesconto;
import strategy.impostos.model.Item;
import strategy.impostos.model.Orcamento;

public class TestaCorrenteDeDescontos {

	public static void main(String[] args) {
		TestaCorrenteDeDescontos t = new TestaCorrenteDeDescontos();
		t.Descontar();
	}

	private void Descontar() {
		Orcamento orcamento = new Orcamento(600);
		Item item1 = new Item("Book: Clean Code + e-book", 120.0);
		orcamento.adicionarItem(item1);
		Item item2 = new Item("Book: Refactoring + e-book", 300.0);
		orcamento.adicionarItem(item2);
		Item item3 = new Item("Book: Design Patterns + e-book", 180.0);
		orcamento.adicionarItem(item3);
		Item lapis = new Item("LAPIS", 15.00);
		orcamento.adicionarItem(lapis);
		
		CalculadorDeDescontos c = new CalculadorDeDescontos();
		Desconto desconto = FabricaDaCorrenteDeDesconto.DescontosPadrao();
		double valorDesconto = c.valorDesconto(orcamento, desconto);
		System.out.println(valorDesconto);
	}
}
