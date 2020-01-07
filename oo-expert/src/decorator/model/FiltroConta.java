package decorator.model;

import java.util.ArrayList;
import java.util.List;

import strategy.investimentos.model.Conta;

public abstract class FiltroConta {

	protected final FiltroConta outroFiltro;

	public FiltroConta() {
		this.outroFiltro = null;
	}

	public FiltroConta(FiltroConta outroFiltro) {
		this.outroFiltro = outroFiltro;
	}

	public abstract List<Conta> aplicarFiltro(List<Conta> contas);
	
	public List<Conta> proximo(List<Conta> contas) {
		if (this.outroFiltro == null) {
			return new ArrayList<Conta>();
		} else {
			return this.outroFiltro.aplicarFiltro(contas);
		}
	}
}
