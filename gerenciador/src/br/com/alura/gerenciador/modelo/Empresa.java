package br.com.alura.gerenciador.modelo;

import java.util.Date;

public class Empresa {
	final private Integer id;
	final private String nome;
	private Date dataAbertura = new Date();

	public Empresa(Integer id, String nome, Date dataAbertura) {
		this.id = id;
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}

}
