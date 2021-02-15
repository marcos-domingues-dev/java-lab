package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Conta;

public class TesteCriarContas {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
				
		CriarContaDoHomemAranha(em);	
		CriarContaDoDoutorEstranho(em);
		
		emf.close();
	}

	private static void CriarContaDoDoutorEstranho(EntityManager em) {
		Conta outraConta = new Conta(); // -> Estado JPA "Transient"
		outraConta.setAgencia(137);
		outraConta.setNumero(575);
		outraConta.setTitular("Dr. Steven Strange");
		outraConta.setSaldo(100.0);
		
		em.getTransaction().begin();
		em.persist(outraConta);         // -> Estado JPA "Managed"
		em.getTransaction().commit();
	}

	private static void CriarContaDoHomemAranha(EntityManager em) {
		Conta conta = new Conta();
		conta.setAgencia(1234);
		conta.setNumero(4445);
		conta.setTitular("Peter Parker");
		
		em.getTransaction().begin();
		em.persist(conta);		
		em.getTransaction().commit();
	}
}
