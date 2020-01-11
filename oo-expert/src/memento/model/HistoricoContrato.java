package memento.model;

import java.util.ArrayList;
import java.util.List;

public class HistoricoContrato {
	private List<EstadoContrato> items = new ArrayList<EstadoContrato>();
	
	public void adicionar(EstadoContrato estadoContrato) {
		items.add(estadoContrato);
	}
	
	public EstadoContrato buscar(int indice) {
		return items.get(indice);
	}
}
