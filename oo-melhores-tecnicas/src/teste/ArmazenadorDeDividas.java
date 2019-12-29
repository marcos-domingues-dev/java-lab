package teste;

import java.util.Collection;
import java.util.Map.Entry;

import modelo.Divida;
import modelo.Documento;

public interface ArmazenadorDeDividas {

	Divida buscar(Documento documento);
	void salvar(Divida divida);
	Collection<Entry<Documento, Divida>> listar();
	
}
