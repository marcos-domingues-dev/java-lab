package decorator.test;

import java.util.ArrayList;
import java.util.List;

import decorator.model.FiltroConta;
import strategy.investimentos.model.Conta;

public class FiltroContaMaiorDeQuinhentosMil extends FiltroConta {

	public FiltroContaMaiorDeQuinhentosMil() {
	}

	public FiltroContaMaiorDeQuinhentosMil(FiltroConta filtroConta) {
		super(filtroConta);
	}

	@Override
	public List<Conta> aplicarFiltro(List<Conta> contas) {
		List<Conta> filtradas = new ArrayList<Conta>();
		for (Conta conta : contas) {
			if (conta.getSaldo() >= 500000) {
				filtradas.add(conta);
			}
		}
		
		filtradas.addAll(proximo(contas)); // -> The magic is here!
		return filtradas;
	}

}
