package interpreter.model;

public class Numero implements ExpressaoNumerica {
	
	private int valor;

	public Numero(int valor) {
		this.valor = valor;
	}

	@Override
	public int avaliar() {
		return valor;
	}

}
