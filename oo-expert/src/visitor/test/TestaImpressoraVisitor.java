package visitor.test;

import interpreter.model.Divisao;
import interpreter.model.ExpressaoNumerica;
import interpreter.model.Multiplicacao;
import interpreter.model.Numero;
import interpreter.model.Soma;
import interpreter.model.Subtracao;
import visitor.model.ExpressaoNumericaVisitor;
import visitor.model.Impressora;

public class TestaImpressoraVisitor {
	
	public static void main(String[] args) {

		// Visitor: Um anfitrião "árvore" define aceitar "accept()" seus visitantes.
		
		// Anfitrião => ExpressaoNumerica / Estrutura de Dados que será visitada.
		// Visitante => Sujeito educado que sabe como se comportar (assinou o contrato de visita).
		
		ExpressaoNumerica numeroUm = new Numero(1);
		ExpressaoNumerica numeroDois = new Numero(2);
		ExpressaoNumerica numeroTres = new Numero(3);

		ExpressaoNumerica umMaisDois = new Soma(numeroUm, numeroDois);
		ExpressaoNumerica doisMaisTres = new Soma(numeroDois, numeroTres);
		ExpressaoNumerica cincoMenosUm = new Subtracao(doisMaisTres, numeroUm);
		ExpressaoNumerica multiplicaQuatroVezesTres = new Multiplicacao(cincoMenosUm, umMaisDois);
		ExpressaoNumerica anfitriao = new Divisao(multiplicaQuatroVezesTres, numeroDois);

		ExpressaoNumericaVisitor impressoraVisitante = new Impressora();
		
		anfitriao.aceitarVisitante(impressoraVisitante); // accept() -> Estrutura de dados 
		// O anfitrião recebeu um visitante.
		// O visitante ainda não sabe como será a visita.
		// Internamente, sendo o anfitriao uma Divisao, ele diz: visitarDivisao().
		
		

		System.out.println("=" + anfitriao.avaliar()); // Avaliar = Interpretar
	}
}
