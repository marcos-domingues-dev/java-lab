package interpreter.model;

public class Soma implements ExpressaoNumerica {

	private ExpressaoNumerica esquerda;
	private ExpressaoNumerica direita;

	public Soma(ExpressaoNumerica esquerda, ExpressaoNumerica direita) {
		this.esquerda = esquerda;
		this.direita = direita;

	}

	@Override
	public int avaliar() {
		int valorEsquerda = esquerda.avaliar();
		int valorDireita = direita.avaliar();
		
		return valorEsquerda + valorDireita;
	}
}
