package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Conta;

public class TesteContaComSaldoParaMerge {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		CriarContaDoCapitaoAmerica(em);
		CriarContaDoHulk(em);
		
		Conta contaEncontrada = em.find(Conta.class, 3L); // -> Estado JPA "Managed"
		em.close(); // -> Passará 'contaEncontrada' para estado "Detached".

		EntityManager em2 = emf.createEntityManager();
		
		contaEncontrada.setSaldo(570.0);
		
		em2.getTransaction().begin();
		em2.merge(contaEncontrada); // -> Estado JPA "Managed"
		em2.getTransaction().commit();
	}

	private static void CriarContaDoHulk(EntityManager em) {
		TesteContasRepository.resgatarContaDoHulk(em);
	}

	private static void CriarContaDoCapitaoAmerica(EntityManager em) {
		TesteContasRepository.resgatarContaDoCapitaoAmerica(em);
	}
}
