package br.com.alura.gerenciador.servlet;

public class Empresa {
	final private Integer id;
	final private String nome;

	public Empresa(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
