package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Conta;

public class TesteExcluirConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaLoki = BuscarContaDoLoki(em);
		System.out.println();
		System.out.println("--- * ---");

		System.out.println(contaLoki.getTitular());

		em.getTransaction().begin();
		em.remove(contaLoki); // "Managed" -> "Removed"
		em.getTransaction().commit();

		emf.close();
	}

	private static Conta BuscarContaDoLoki(EntityManager em) {

		Conta conta = em.find(Conta.class, 6L); // "Managed"
		if (conta != null) {
			return conta;
		}

		conta = new Conta(); // "Transient"
		conta.setAgencia(137);
		conta.setNumero(666);
		conta.setTitular("Loki");
		conta.setSaldo(999.0);

		em.getTransaction().begin();
		em.persist(conta); // "Transient" -> "Managed"
		em.getTransaction().commit();

		return conta;
	}
}
