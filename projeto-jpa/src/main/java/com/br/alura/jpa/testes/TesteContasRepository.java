package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;

import com.br.alura.jpa.modelo.Conta;

public class TesteContasRepository {

	public static Conta resgatarContaDoHulk(EntityManager em) {
		Conta conta = em.find(Conta.class, 4L);
		
		if (conta == null) {			
			conta = new Conta(); // -> Estado JPA "Transient"
			conta.setAgencia(137);
			conta.setNumero(654321);
			conta.setTitular("Bruce Benner");
			conta.setSaldo(890000.0);
			
			em.getTransaction().begin();
			em.persist(conta); // -> Estado JPA "Managed"
			em.getTransaction().commit();
		}
		
		return conta;
	}

	public static Conta resgatarContaDoCapitaoAmerica(EntityManager em) {
		Conta conta = em.find(Conta.class, 3L);
		
		if (conta == null) {
			conta = new Conta();
			conta.setAgencia(137);
			conta.setNumero(123456);
			conta.setTitular("Steven Rogers");
			conta.setSaldo(120.0);
			
			em.getTransaction().begin();
			em.persist(conta);
			em.getTransaction().commit();
		}
		return conta;
	}	
}
