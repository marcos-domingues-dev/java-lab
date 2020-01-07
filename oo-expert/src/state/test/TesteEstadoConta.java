package state.test;

import strategy.investimentos.model.Conta;

public class TesteEstadoConta {

	public static void main(String[] args) {
		Conta conta = new Conta("Robert C. Martin", 500);
		
		System.out.println(conta.toString());
		
		conta.sacar(600);		
		System.out.println(conta.toString());
		
		// conta.sacar(600); // Exception estado de saldo negativo!
		
		conta.depositar(100);		
		System.out.println(conta.toString());
		
		conta.depositar(100);		
		System.out.println(conta.toString());
	}
}
