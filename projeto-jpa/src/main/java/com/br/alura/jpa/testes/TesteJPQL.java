package com.br.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.br.alura.jpa.modelo.Conta;
import com.br.alura.jpa.modelo.Movimentacao;
import com.br.alura.jpa.testes.repositorios.TesteContasRepository;

public class TesteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoCapitao = TesteContasRepository.resgatarContaDoCapitaoAmerica(em);
		
		String sql = "select m from Movimentacao m where m.conta = :pConta";
		TypedQuery<Movimentacao> q = em.createQuery(sql, Movimentacao.class);		
		q.setParameter("pConta", contaDoCapitao);
		List<Movimentacao> movimentacoes = q.getResultList();
		
		for (Movimentacao m : movimentacoes) {
			System.out.println(m.getDescricao() + " - " + m.getTipoMovimentacao() + " - " + m.getValor());
		}
	}
}
