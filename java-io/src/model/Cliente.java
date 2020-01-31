package model;

import java.io.Serializable;

public class Cliente implements Serializable {

	// Uma interface sem métodos é chamada de "interface de marcação": java.io.Serializable
	// O serialVersionUID é da classe (por isso estático) e define a versão ou identificação numérica da classe.

	private static final long serialVersionUID = 1L; 
	private String nome;
	private String cpf;
	private String profissao; 

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(final String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + 
		" - CPF: " + this.cpf + 
		" - Profissão: " + this.profissao;
	}

}
