package modelo;

public class Divida {
	private double total;
	private String credor;
	private Documento documentoCredor;
	private Pagamentos pagamentos = new Pagamentos();

	public Divida(Cnpj cnpjCredor) {
		this.documentoCredor = cnpjCredor;
	}

	public void registrarPagamento(Pagamento pagamento) {
		this.pagamentos.registra(pagamento);
	}
	
	public double getValorPago() {
		return this.pagamentos.getValorPago();
	}

	public Documento getDocumentoCredor() {
		return documentoCredor;
	}

	public String getCredor() {
		return this.credor;
	}

	public double getTotal() {
		return this.total;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double valorAPagar() {
		return this.total - this.pagamentos.getValorPago();
	}

	@Override
	public String toString() {
		return "Credor=" + this.credor + " " + this.documentoCredor.getValor() + " " + "Total=" + this.total + " "
				+ "Valor pago=" + this.pagamentos.getValorPago() + " " + "Saldo=" + valorAPagar();

	}
}