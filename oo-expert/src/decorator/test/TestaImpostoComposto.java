package decorator.test;

import decorator.model.ImpostoComposto;
import strategy.impostos.model.Iccc;
import strategy.impostos.model.Icms;
import strategy.impostos.model.Imposto;
import strategy.impostos.model.Item;
import strategy.impostos.model.Orcamento;

public class TestaImpostoComposto {

	public static void main(String[] args) {
		Imposto icms = new Icms();
		Imposto iccc = new Iccc();// --> new Iccc(icms); Cuidado! 
		ImpostoComposto icmsComIccc = new Icms(new Iccc());
		
		Item caneta = new Item("CANETA", 12.0);
		Item lapis = new Item("LAPIS", 0.5);
		
		Orcamento orcamento = new Orcamento(100);
		orcamento.adicionarItem(caneta);
		orcamento.adicionarItem(lapis);
		
		System.out.println(icms.valor(orcamento));
		System.out.println(iccc.valor(orcamento));
		System.out.println(icmsComIccc.valor(orcamento));
	}
}
