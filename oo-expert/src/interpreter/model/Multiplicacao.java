package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

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

	public ExpressaoNumerica getEsquerda() {
		return esquerda;
	}

	public ExpressaoNumerica getDireita() {
		return direita;
	}

	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarMultiplicacao(this);
	}
}
