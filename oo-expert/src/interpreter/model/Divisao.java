package interpreter.model;

public class Divisao implements ExpressaoNumerica {
	private ExpressaoNumerica esquerda;
	private ExpressaoNumerica direita;

	public Divisao(ExpressaoNumerica esquerda, ExpressaoNumerica direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	}
	
	@Override
	public int avaliar() {
		return esquerda.avaliar() / direita.avaliar();
	}
}
