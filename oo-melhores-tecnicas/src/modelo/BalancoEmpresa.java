package modelo;

import java.util.Map.Entry;

import teste.ArmazenadorDeDividas;

public class BalancoEmpresa {
	private ArmazenadorDeDividas armazemDeDividas;

	public BalancoEmpresa(ArmazenadorDeDividas armazemDeDividas) {
		this.armazemDeDividas = armazemDeDividas;
	}

	public void registraDivida(Divida divida) {
		armazemDeDividas.salvar(divida);
	}

	public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
		Divida divida = armazemDeDividas.buscar(documentoCredor);
		if (divida != null) {
			divida.registrarPagamento(pagamento);
		}
		armazemDeDividas.salvar(divida);
	}

	@Override
	public String toString() {
		String textoSaida = "";
		for (Entry<Documento, Divida> item : armazemDeDividas.listar()) {
			textoSaida += item.getValue().toString();
		}
		return textoSaida;
	}
}