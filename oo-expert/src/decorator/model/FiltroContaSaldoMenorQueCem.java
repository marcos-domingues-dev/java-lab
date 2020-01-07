package decorator.model;

import java.util.ArrayList;
import java.util.List;

import strategy.investimentos.model.Conta;

public class FiltroContaSaldoMenorQueCem extends FiltroConta {

	public FiltroContaSaldoMenorQueCem() {
	}

	public FiltroContaSaldoMenorQueCem(FiltroConta filtroConta) {
		super(filtroConta);
	}

	@Override
	public List<Conta> aplicarFiltro(List<Conta> contas) {
		List<Conta> filtradas = new ArrayList<Conta>();
		for (Conta conta : contas) {
			if (conta.getSaldo() <= 100) {
				filtradas.add(conta);
			}
		}
		
		filtradas.addAll(proximo(contas)); // -> The magic is here!
		return filtradas;
	}
}
