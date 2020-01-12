package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

public class Numero implements ExpressaoNumerica {
	
	private int valor;

	public Numero(int valor) {
		this.valor = valor;
	}

	@Override
	public int avaliar() {
		return valor;
	}

	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarNumero(this);
	}

}
