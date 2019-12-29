package modelo;

import java.text.NumberFormat;

public class RelatorioDeDivida {

	private Divida divida;

	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}

	public void gerarRelatorio(NumberFormat formatadorDeNumeros) {
		System.out.println("Nome credor: " + this.divida.getCredor());
		System.out.println("CNPJ credor: " + this.divida.getDocumentoCredor());

		System.out.println("Valor da dívida: " + formatadorDeNumeros.format(this.divida.getTotal()));
		System.out.println("Valor pago: " + formatadorDeNumeros.format(this.divida.getValorPago()));
		System.out.println("Saldo: " + formatadorDeNumeros.format(this.divida.valorAPagar()));
	}

}
