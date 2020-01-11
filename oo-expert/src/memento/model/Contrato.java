package memento.model;

import java.util.Calendar;

public class Contrato {

	private String nome;
	private Calendar data;
	private TipoContrato tipo;

	public Contrato(String nome, Calendar data, TipoContrato tipo) {
		this.nome = nome;
		this.data = data;
		this.tipo = tipo;
	}

	public void Avancar() {
		if (this.tipo.equals(TipoContrato.NOVO)) {
			this.tipo = TipoContrato.EM_ANDAMENTO;
		} else if (this.tipo.equals(TipoContrato.EM_ANDAMENTO)) {
			this.tipo = TipoContrato.ACERTADO;
		} else if (this.tipo.equals(TipoContrato.ACERTADO)) {
			this.tipo = TipoContrato.CONCLUIDO;
		}
	}
	
	public EstadoContrato gerarEstadoAtual() {
		Contrato clone = new Contrato(this.nome, this.data, this.tipo);
		return new EstadoContrato(clone);
	}
	
	@Override
	public String toString() {
		return "Nome: " + this.nome +
				//" Data: " + this.data + 
				" Tipo: " + this.tipo;
	}

	public String getNome() {
		return nome;
	}

	public Calendar getData() {
		return data;
	}

	public TipoContrato getTipo() {
		return tipo;
	}

}
