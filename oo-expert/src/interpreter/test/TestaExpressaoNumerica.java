package interpreter.test;

import interpreter.model.ExpressaoNumerica;
import interpreter.model.Numero;
import interpreter.model.Soma;
import interpreter.model.Subtracao;

public class TestaExpressaoNumerica {

	public static void main(String[] args) {
		
		// DSL = Domain-Specific Language
		
		ExpressaoNumerica numeroUm = new Numero(1);
		ExpressaoNumerica numeroDois = new Numero(2);
		ExpressaoNumerica numeroTres = new Numero(3);

		ExpressaoNumerica umMaisDois = new Soma(numeroUm, numeroDois);
		System.out.println(umMaisDois.avaliar());

		ExpressaoNumerica doisMaisTres = new Soma(numeroDois, numeroTres);
		ExpressaoNumerica resultado = new Subtracao(doisMaisTres, numeroUm);
		System.out.println(resultado.avaliar());
	}
}
