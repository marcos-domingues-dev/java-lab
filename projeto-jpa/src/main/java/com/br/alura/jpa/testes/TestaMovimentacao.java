package com.br.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Conta;
import com.br.alura.jpa.modelo.Movimentacao;
import com.br.alura.jpa.modelo.TipoMovimentacao;
import com.br.alura.jpa.testes.repositorios.TesteContasRepository;

public class TestaMovimentacao {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta contaDoCapitaoAmerica = TesteContasRepository.resgatarContaDoCapitaoAmerica(em);
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Clube do herói");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(new BigDecimal(500.0));
		movimentacao.setConta(contaDoCapitaoAmerica);
		
		em.getTransaction().begin();
		em.persist(movimentacao);
		em.getTransaction().commit();		
		em.close();
	}

}
