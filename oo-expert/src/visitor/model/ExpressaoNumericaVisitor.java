package visitor.model;

import interpreter.model.Divisao;
import interpreter.model.Multiplicacao;
import interpreter.model.Numero;
import interpreter.model.RaizQuadrada;
import interpreter.model.Soma;
import interpreter.model.Subtracao;

public interface ExpressaoNumericaVisitor {

	// Um visitante ................ (de expressões - interface gerérica)
	// sabe como se comportar ...... (o que fazer), 
	// de acordo com o anfitrião ... (como visitar cada nó - cada classe concreta):
	
	void visitarSoma(Soma soma);

	void visitarSubtracao(Subtracao subtracao);

	void visitarNumero(Numero numero);

	void visitarMultiplicacao(Multiplicacao multiplicacao);

	void visitarDivisao(Divisao divisao);

	void visitarRaizQuadrada(RaizQuadrada raizQuadrada);

}