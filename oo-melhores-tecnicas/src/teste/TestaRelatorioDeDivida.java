package teste;

import java.text.NumberFormat;
import java.util.Locale;

import modelo.Cnpj;
import modelo.Divida;
import modelo.Pagamento;
import modelo.RelatorioDeDivida;

public class TestaRelatorioDeDivida {

	public static void main(String[] args) {
		Cnpj cnpjCredor = new Cnpj("001");
		Divida divida = new Divida(cnpjCredor);
		divida.setCredor("Martin Fowler");
		divida.setTotal(15000);
		
		Cnpj cnpjPagador = new Cnpj("004");
		Pagamento pagamento = new Pagamento(cnpjPagador);
		pagamento.setValor(50);
		divida.registrarPagamento(pagamento);
		
		RelatorioDeDivida relatorioDeDivida = new RelatorioDeDivida(divida);
		NumberFormat formatadorDeNumeros = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		relatorioDeDivida.gerarRelatorio(formatadorDeNumeros);
	}
}
