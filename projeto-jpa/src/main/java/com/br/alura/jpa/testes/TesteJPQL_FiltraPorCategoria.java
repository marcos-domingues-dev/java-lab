package com.br.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.br.alura.jpa.modelo.Categoria;
import com.br.alura.jpa.modelo.Movimentacao;
import com.br.alura.jpa.testes.repositorios.TesteCategoriasRepository;

public class TesteJPQL_FiltraPorCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = TesteCategoriasRepository.resgatarFerias(em);
		
		String sql = "select m from Movimentacao m join m.categorias c where c = :pCategoria";
		TypedQuery<Movimentacao> q = em.createQuery(sql, Movimentacao.class);		
		q.setParameter("pCategoria", categoria);
		List<Movimentacao> movimentacoes = q.getResultList();
		
		System.out.println();
		System.out.println();
		for (Movimentacao m : movimentacoes) {
			System.out.println(m.getDescricao() + " - " + m.getTipoMovimentacao() + " - " + m.getValor());
		}
	}
}
