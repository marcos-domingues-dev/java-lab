package com.br.alura.jpa.testes;

import javax.persistence.EntityManager;

import com.br.alura.jpa.modelo.Categoria;

public class TesteCategoriasRepository {

	public static Categoria resgatarViagem(EntityManager em) {
		Categoria viagem = em.find(Categoria.class, 1L);

		if (viagem == null) {
			viagem = new Categoria("Viagem");

			em.getTransaction().begin();
			em.persist(viagem);
			em.getTransaction().commit();
		}
		return viagem;
	}

	public static Categoria resgatarTrabalho(EntityManager em) {
		Categoria trabalho = em.find(Categoria.class, 2L);

		if (trabalho == null) {
			trabalho = new Categoria("Trabalho");

			em.getTransaction().begin();
			em.persist(trabalho);
			em.getTransaction().commit();
		}
		return trabalho;
	}

	public static Categoria resgatarFerias(EntityManager em) {
		Categoria ferias = em.find(Categoria.class, 3L);

		if (ferias == null) {
			ferias = new Categoria("Ferias");

			em.getTransaction().begin();
			em.persist(ferias);
			em.getTransaction().commit();
		}
		return ferias;
	}

}
