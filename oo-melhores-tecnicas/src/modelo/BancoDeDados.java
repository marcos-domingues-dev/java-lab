package modelo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import teste.ArmazenadorDeDividas;

public class BancoDeDados implements ArmazenadorDeDividas {
	private Map<Documento, Divida> dividas = new HashMap<Documento, Divida>();

	public BancoDeDados(String host, String user, String password) {
		conectar(host, user, password);
	}

	public boolean conectar(String host, String user, String password) {

		return true;
	}

	public void desconectar() {

	}

	public void salvar(Divida divida) {
		dividas.put(divida.getDocumentoCredor(), divida);
	}

	public Divida buscar(Documento documento) {
		return dividas.get(documento);
	}
	
	public Collection<Entry<Documento,Divida>> listar() {
		return dividas.entrySet();
		
	}
}
