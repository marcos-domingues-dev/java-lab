package modelo;

import java.util.HashMap;

public class BalancoEmpresa {

	private HashMap<String, Divida> dividas = new HashMap<String, Divida>();

	public void adicionaDivida(String credor, String cnpjCredor, double valor) {
		Divida divida = new Divida();
		divida.setNomeCredor(credor);
		divida.setCnpjCredor(cnpjCredor);
		divida.setValorTotal(valor);

		dividas.put(cnpjCredor, divida);
	}

	public void pagar(String cnpjCredor, double valor) {
		Divida d = dividas.get(cnpjCredor);
		if (d != null) {
			d.paga(valor);
		}
	}

}
