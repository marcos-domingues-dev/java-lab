package br.com.bytebank.bytebanksystem.test;

import br.com.bytebank.bytebanksystem.model.Customer;
import br.com.bytebank.bytebanksystem.model.LocalSystem;

//Para "qualificar" as classes, utiliza-se o nome completo: nomeDoPacote.NomeDaClasse
//Pacotes são pastas.

//Full Qualified Name ou FQN

public class LocalSystemTester {

	public static void main(String[] args) {

		Customer ironMan = new Customer();
		ironMan.setName("Iron Man");

		LocalSystem localSystem = new LocalSystem();
		if (localSystem.login(ironMan.getAuth())) {
			System.out.println("Login by: " + ironMan.getName());
		} else {
			System.out.println("Access denied to: " + ironMan.getName());
		}
	}
}
