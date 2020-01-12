package visitor.model;

import interpreter.model.Divisao;
import interpreter.model.Multiplicacao;
import interpreter.model.Numero;
import interpreter.model.RaizQuadrada;
import interpreter.model.Soma;
import interpreter.model.Subtracao;

public class ImpressoraPrefixa implements ExpressaoNumericaVisitor {

	@Override
	public void visitarNumero(Numero numero) {
		System.out.print(numero.avaliar());
	}
	
	@Override
	public void visitarSoma(Soma soma) {
		// Cada expressão da soma aceita um visitante.
		System.out.print("+");
		System.out.print(" ");
		System.out.print("(");
		soma.getEsquerda().aceitarVisitante(this); // -> Visitar esquerda.
		System.out.print(" ");
		soma.getDireita().aceitarVisitante(this); // -> Visitar direita.
		System.out.print(")");
	}
	
	@Override
	public void visitarSubtracao(Subtracao subtracao) {
		System.out.print("-");
		System.out.print(" ");
		System.out.print("(");
		subtracao.getEsquerda().aceitarVisitante(this);
		System.out.print(" ");
		subtracao.getDireita().aceitarVisitante(this);
		System.out.print(")");
	}
	
	@Override
	public void visitarMultiplicacao(Multiplicacao multiplicacao) {
		System.out.print("*");
		System.out.print(" ");
		System.out.print("(");
		multiplicacao.getEsquerda().aceitarVisitante(this);
		System.out.print(" ");
		multiplicacao.getDireita().aceitarVisitante(this);
		System.out.print(")");
	}

	@Override
	public void visitarDivisao(Divisao divisao) {
		System.out.print("/");
		System.out.print(" ");
		System.out.print("(");
		divisao.getEsquerda().aceitarVisitante(this);
		System.out.print(" ");
		divisao.getDireita().aceitarVisitante(this);
		System.out.print(")");
	}

	@Override
	public void visitarRaizQuadrada(RaizQuadrada raizQuadrada) {
		System.out.println("√");
		System.out.print("(");
		raizQuadrada.getExpressao().aceitarVisitante(this);
		System.out.print(")");
	}
}