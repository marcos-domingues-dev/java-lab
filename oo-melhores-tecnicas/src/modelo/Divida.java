package modelo;

public class Divida {

	private double valorTotal;
	private double valorPago;
	private String nomeCredor;
	private String cnpjCredor;

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getNomeCredor() {
		return nomeCredor;
	}

	public void setNomeCredor(String nomeCredor) {
		this.nomeCredor = nomeCredor;
	}

	public String getCnpjCredor() {
		return cnpjCredor;
	}

	public void setCnpjCredor(String cnpjCredor) {
		this.cnpjCredor = cnpjCredor;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void paga(double valor) {
		this.valorPago += valor;
	}
}
