package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

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

	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarSubtracao(this);
	}

	public ExpressaoNumerica getEsquerda() {
		return esquerda;
	}

	public ExpressaoNumerica getDireita() {
		return direita;
	}
}
