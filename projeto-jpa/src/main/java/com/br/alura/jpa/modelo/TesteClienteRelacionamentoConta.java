package com.br.alura.jpa.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteClienteRelacionamentoConta {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		// Conta contaDoCapitaoAmerica =
		// TesteContasRepository.resgatarContaDoCapitaoAmerica(em);
		Conta contaDoCapitaoAmerica = new Conta();
		contaDoCapitaoAmerica.setId(3);

		Cliente capitao = new Cliente();
		capitao.setNome("Capitão América");
		capitao.setEndereco("Av New York, 123");
		capitao.setConta(contaDoCapitaoAmerica);

		em.getTransaction().begin();
		em.persist(capitao);
		em.getTransaction().commit();
		em.close();
	}

}
