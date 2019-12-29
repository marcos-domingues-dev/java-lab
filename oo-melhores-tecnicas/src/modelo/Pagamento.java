package modelo;

import java.util.Calendar;

public class Pagamento {
	private String pagador;
	private Documento documentoPagador;
	private double valor;
	private Calendar data;

	public Pagamento(Cnpj cnpjPagador) {
		this.documentoPagador = cnpjPagador;
	}
	
	@Override
	public String toString() {
		return "Pagador: " + this.pagador + 
			" Cnpj: " + this.documentoPagador.getValor() + 
			" Data: " + this.data +
			" Valor: " + this.valor;
	}

	public String getPagador() {
		return this.pagador;
	}

	public void setPagador(String pagador) {
		this.pagador = pagador;
	}

	public Documento getDocumentoPagador() {
		return this.documentoPagador;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return this.data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
}