package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Conta;

public class TesteAlterarContas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = em.find(Conta.class, 1L); // -> Estado JPA "Managed"	
		System.out.println(conta.getTitular());
		
		em.getTransaction().begin();
		conta.setSaldo(500.0); // -> Estado JPA "Managed"
		em.getTransaction().commit();
		
		emf.close();
	}
}
