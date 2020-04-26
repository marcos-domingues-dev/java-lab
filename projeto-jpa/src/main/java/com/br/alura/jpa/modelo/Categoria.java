package com.br.alura.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String nome;

	@Deprecated
	public Categoria() { // -> Precisa para a infra do Hibernate
	}

	public Categoria(String nome) {
		super();
		this.nome = nome;
	}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

}
