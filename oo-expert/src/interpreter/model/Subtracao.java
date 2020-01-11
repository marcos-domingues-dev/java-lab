package interpreter.model;

public class Subtracao implements ExpressaoNumerica {

	private ExpressaoNumerica esquerda;
	private ExpressaoNumerica direita;

	public Subtracao(ExpressaoNumerica esquerda, ExpressaoNumerica direita) {
		this.esquerda = esquerda;
		this.direita = direita;

	}

	@Override
	public int avaliar() {
		int valorEsquerda = esquerda.avaliar();
		int valorDireita = direita.avaliar();

		return valorEsquerda - valorDireita;
	}

}
