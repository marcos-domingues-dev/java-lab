package interpreter.model;

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
}
