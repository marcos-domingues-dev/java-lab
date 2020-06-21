package br.com.caelum;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.caelum.model.Produto;

public class TestaCache {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfigurator.class);
		EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean(EntityManagerFactory.class);
		
		EntityManager em = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager(); 
		 
		Produto p1 = em.find(Produto.class, 1);
		System.out.println(p1.getNome());
		
		Produto p2 = em2.find(Produto.class, 1);		 
		System.out.println(p2.getNome());
		 
		 em.close();
		 em2.close();
		 
		 ctx.close();
	}
	
}
