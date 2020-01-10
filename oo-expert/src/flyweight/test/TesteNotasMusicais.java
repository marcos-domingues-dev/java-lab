package flyweight.test;

import java.util.Arrays;
import java.util.List;

import flyweight.model.NotaMusical;
import flyweight.model.NotasMusicais;

public class TesteNotasMusicais {

	public static void main(String[] args) {
		NotasMusicais notas = new NotasMusicais();
		
		List<NotaMusical> musica = Arrays.asList(
				notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("mi"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    

	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("re"),    
	            notas.pega("re"),

	            notas.pega("do"),    
	            notas.pega("sol"),    
	            notas.pega("fa"),    
	            notas.pega("mi"),    
	            notas.pega("mi"),    
	            notas.pega("mi"),

	            notas.pega("do"),    
	            notas.pega("re"),    
	            notas.pega("mi"),    
	            notas.pega("fa"),    
	            notas.pega("fa"),    
	            notas.pega("fa")
				
				);
		
		Piano piano = new Piano();
		piano.Tocar(musica);
	}
}
