package interpreter.model;

import visitor.model.ExpressaoNumericaVisitor;

public class RaizQuadrada implements ExpressaoNumerica {
	private ExpressaoNumerica expressao;

	public RaizQuadrada(ExpressaoNumerica expressao) {
		this.expressao = expressao;
	}

	@Override
	public int avaliar() {
		int valor = expressao.avaliar();
		double resultado = Math.sqrt(valor);
		
		return (int) resultado;
	}

	public ExpressaoNumerica getExpressao() {
		return expressao;
	}

	@Override
	public void aceitarVisitante(ExpressaoNumericaVisitor visitante) {
		visitante.visitarRaizQuadrada(this);
	}
}
