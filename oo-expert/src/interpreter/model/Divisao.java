package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

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

	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarDivisao(this);
	}

	public ExpressaoNumerica getEsquerda() {
		return esquerda;
	}

	public ExpressaoNumerica getDireita() {
		return direita;
	}
}
