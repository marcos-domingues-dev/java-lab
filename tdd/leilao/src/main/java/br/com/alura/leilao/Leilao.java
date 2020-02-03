package br.com.alura.leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;

	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}

	public void propoe(Lance lance) {
		int countUserLances = qtdLancesDo(lance.getUsuario());
		Boolean userFezDoisLancesEmSequencia = (!this.lances.isEmpty()
				&& ultimoLanceDado().getUsuario().equals(lance.getUsuario()));

		if (countUserLances < 5 && !userFezDoisLancesEmSequencia) {
			lances.add(lance);
		}
	}

	private int qtdLancesDo(Usuario usuario) {
		int countUserLances = 0;
		for (Lance lance : this.lances) {
			if (lance.getUsuario().equals(usuario))
				countUserLances++;
		}
		return countUserLances;
	}

	private Lance ultimoLanceDado() {
		if (this.lances.isEmpty())
			return null;
		return this.lances.get(this.lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public void dobrarUltimoLance(Usuario usuario) {
		Lance ultimoLance = ultimoLanceDo(usuario);
		if (ultimoLance != null) {
			Lance lanceEmDobro = new Lance(usuario, ultimoLance.getValor() * 2);
			propoe(lanceEmDobro);
		}
	}

	private List<Lance> pegarLancesInvertidos() {
		List<Lance> lancesClone = new ArrayList<Lance>(this.lances);
		Collections.reverse(lancesClone);
		return lancesClone;
	}

	private Lance ultimoLanceDo(Usuario usuario) {
		List<Lance> lancesInvertidos = pegarLancesInvertidos();
		for (Lance lance : lancesInvertidos) {
			if (lance.getUsuario().equals(usuario)) {
				return lance;
			}
		}
		return null;
	}

	public double getValorUltimoLanceDo(Usuario usuario) {
		Lance ultimoLance = ultimoLanceDo(usuario);
		if (ultimoLance != null) {
			return ultimoLance.getValor();
		}
		return 0;
	}

}
