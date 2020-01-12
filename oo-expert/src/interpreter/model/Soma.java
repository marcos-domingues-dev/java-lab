package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

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
	
	public ExpressaoNumerica getEsquerda() {
		return esquerda;
	}

	public ExpressaoNumerica getDireita() {
		return direita;
	}
	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarSoma(this);
	}
}
