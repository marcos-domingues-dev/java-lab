package com.br.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.br.alura.jpa.modelo.Categoria;
import com.br.alura.jpa.modelo.Conta;
import com.br.alura.jpa.modelo.Movimentacao;
import com.br.alura.jpa.modelo.TipoMovimentacao;
import com.br.alura.jpa.testes.repositorios.TesteCategoriasRepository;
import com.br.alura.jpa.testes.repositorios.TesteContasRepository;

public class TestaMovimentacaoComCategorias {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta contaDoCapitaoAmerica = TesteContasRepository.resgatarContaDoCapitaoAmerica(em);

		Categoria viagem = TesteCategoriasRepository.resgatarViagem(em);
		Categoria trabalho = TesteCategoriasRepository.resgatarTrabalho(em);
		Categoria ferias = TesteCategoriasRepository.resgatarFerias(em);
		List<Categoria> viagemATrabalho = Arrays.asList(viagem, trabalho);
		List<Categoria> viagemDeFerias = Arrays.asList(viagem, ferias);

		Movimentacao guerraCivil = criarMovimentacaoSaida(contaDoCapitaoAmerica, viagemATrabalho,
				"Capitão América: Guerra civíl", new BigDecimal(5000.0));

		Movimentacao soldadoInvernal = criarMovimentacaoSaida(contaDoCapitaoAmerica, viagemATrabalho,
				"Capitão América: Soldado invernal", new BigDecimal(800.0));

		Movimentacao baileComAgenteCarter = criarMovimentacaoSaida(contaDoCapitaoAmerica, viagemDeFerias,
				"Vingadores: ultimato", new BigDecimal(800.0));

		em.getTransaction().begin();
		
		em.persist(guerraCivil);
		em.persist(soldadoInvernal);	
		em.persist(baileComAgenteCarter);
		
		em.getTransaction().commit();
		em.close();
	}

	private static Movimentacao criarMovimentacaoSaida(Conta conta, List<Categoria> categorias, String descricao,
			BigDecimal valor) {
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao(descricao);
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(valor);
		movimentacao.setConta(conta);
		movimentacao.setCategorias(categorias);
		return movimentacao;
	}

}
