package flyweight.model;

import java.util.HashMap;
import java.util.Map;

// Uma fábrica, c/ um mapa, que guarda uma instância de cada nota.

public class NotasMusicais {

	private static Map<String, NotaMusical> notas = new HashMap<String, NotaMusical>();

	static {
		notas.put("do", new Do());
		notas.put("re", new Re());
		notas.put("mi", new Mi());
		notas.put("fa", new Fa());
		notas.put("sol", new Sol());
		notas.put("la", new La());
		notas.put("si", new Si());
	}

	public NotaMusical pega(String nota) {
		return notas.get(nota);
	}
}
