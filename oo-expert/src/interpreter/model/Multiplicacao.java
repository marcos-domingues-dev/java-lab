package interpreter.model;

public class Multiplicacao implements ExpressaoNumerica {
	private ExpressaoNumerica esquerda;
	private ExpressaoNumerica direita;

	public Multiplicacao(ExpressaoNumerica esquerda, ExpressaoNumerica direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	@Override
	public int avaliar() {
		return esquerda.avaliar() * direita.avaliar();
	}
}
