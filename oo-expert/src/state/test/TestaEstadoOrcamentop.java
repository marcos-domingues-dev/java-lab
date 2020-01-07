package state.test;

import strategy.impostos.model.Orcamento;

public class TestaEstadoOrcamentop {

	public static void main(String[] args) {
		Orcamento o = new Orcamento(1000);
		//o.aplicarDesconto();
		System.out.println(o.getValor());
		
		o.aprovar();
		o.aplicarDesconto();
		// o.aplicarDesconto(); --> Exception desconto já foi aplicado !
		System.out.println(o.getValor());		
	}
}
