package decorator.test;

import java.util.ArrayList;
import java.util.List;

import decorator.model.FiltroConta;
import decorator.model.FiltroContaSaldoMenorQueCem;
import strategy.investimentos.model.Conta;

public class TestaFiltroConta {

	public static void main(String[] args) {
		List<Conta> contas = new ArrayList<Conta>();
		Conta c1 = new Conta("Robert C. Martin - Author of Clean Code", 95);
		Conta c2 = new Conta("Martin Fowler - Author of Refactoring", 570000);
		Conta c3 = new Conta("Eric Evans - Author of Domain-Driven Design", 54);
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);
		
		System.out.println();
		FiltroConta filtroMenorQueCem = new FiltroContaSaldoMenorQueCem();
		List<Conta> contasSaldoMenorQueCem = filtroMenorQueCem.aplicarFiltro(contas);
		for (Conta c : contasSaldoMenorQueCem) {
			System.out.println(c.toString());
		}
		
		System.out.println();
		FiltroConta filtroMaiorQueQuinhentosMil = new FiltroContaMaiorDeQuinhentosMil();
		List<Conta> contasSaldoMaiorDeQuinhentos = filtroMaiorQueQuinhentosMil.aplicarFiltro(contas);
		for (Conta c : contasSaldoMaiorDeQuinhentos) {
			System.out.println(c.toString());
		}
		
		System.out.println();
		FiltroConta filtroComposto = new FiltroContaMaiorDeQuinhentosMil(new FiltroContaSaldoMenorQueCem());
		List<Conta> contasFiltroComposto = filtroComposto.aplicarFiltro(contas);
		for (Conta c : contasFiltroComposto) {
			System.out.println(c.toString());
		}
	}
}
