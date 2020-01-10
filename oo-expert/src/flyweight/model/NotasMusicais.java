package flyweight.model;

import java.util.HashMap;
import java.util.Map;

// Uma fábrica, c/ um mapa, que guarda uma instância de cada nota.

public class NotasMusicais {

	private static Map<String, NotaMusical> notas = new HashMap<String, NotaMusical>();

//	static {
//		notas.put("do", new Do());
//		notas.put("re", new Re());
//		notas.put("mi", new Mi());
//		notas.put("fa", new Fa());
//		notas.put("sol", new Sol());
//		notas.put("la", new La());
//		notas.put("si", new Si());
//	}

	public NotaMusical pega(String nomeNota) {
		NotaMusical nota = notas.get(nomeNota);
		
		if (nota == null) {
			nota = AdicionarNotaMusical(nomeNota);
		}
		
		return nota;
	}

	private NotaMusical AdicionarNotaMusical(String nomeNota) {
		NotaMusical novaNota = null;

		if (nomeNota.equals("do")) { novaNota = new Do(); }
		else if (nomeNota.equals("re")) { novaNota = new Re(); }
		else if (nomeNota.equals("mi")) { novaNota = new Mi(); }
		else if (nomeNota.equals("fa")) { novaNota = new Fa(); }
		else if (nomeNota.equals("sol")) { novaNota = new Sol(); }
		else if (nomeNota.equals("la")) { novaNota = new La(); }
		else if (nomeNota.equals("si")) { novaNota = new Si(); };
		 
		notas.put(nomeNota, novaNota);
		
		return novaNota;
	}
	
	
	
	/*

@SuppressWarnings("unchecked")
public class NotasMusicais {

    private static Map<String, Nota> notas = new HashMap<String, Nota>();
    private static List<Class<? extends Nota>> clazzes;

    static {
         clazzes = Arrays.asList(
                    Do.class, Re.class, Mi.class, Fa.class, 
                    Sol.class, La.class, Si.class);
    }

    public Nota pega(String nome) {
        try {
            if(!notas.containsKey(nome)) {
                for(Class<? extends Nota> clazz : clazzes) {
                    if(clazz.getSimpleName().toLowerCase().equals(nome)) {
                        notas.put(nome, (Nota) clazz.newInstance());
                        break;
                    }
                }
            }

            return notas.get(nome);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
 
 
	 * */
	
}
