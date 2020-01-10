package flyweight.test;

import java.util.List;

import org.jfugue.player.Player;

import flyweight.model.NotaMusical;

public class Piano {

	
	/* 
	 * Obs.: Para importar a biblioteca "jfugue", baixei o jar em http://www.jfugue.org/jfugue-5.0.9.jar
	 * Depois, salvei o jar na pasta criada lib/
	 * Fiz o refresh no Eclipse
	 * Botão direito no jar: "Build path > Add to build path"
	 */
	
	public void Tocar(List<NotaMusical> musica) {
		Player player = new Player();
		
		StringBuilder composicao = new StringBuilder();		
		for (NotaMusical n : musica) {
			composicao.append(n.simbolo() + " ");
		}
		
		System.out.println(composicao.toString());
		player.play(composicao.toString());
	}
}
