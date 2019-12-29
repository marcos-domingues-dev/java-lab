package teste;

import java.util.Calendar;

import modelo.BalancoEmpresa;
import modelo.BancoDeDados;
import modelo.Cnpj;
import modelo.Divida;
import modelo.Pagamento;

public class TestaAplicacao {

	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados("localhost", "adm", "1234");
		BalancoEmpresa balancoEmpresa = new BalancoEmpresa(bd);
		
		Cnpj cnpjCredor = new Cnpj("009");
		Divida divida = new Divida(cnpjCredor);
		divida.setTotal(1200);
		divida.setCredor("Martin Fowler");
		balancoEmpresa.registraDivida(divida);

		Cnpj cnpjPagador = new Cnpj("004");
		Pagamento pagamento = new Pagamento(cnpjPagador);
		pagamento.setValor(50);
		pagamento.setData(Calendar.getInstance());
		balancoEmpresa.pagaDivida(cnpjCredor, pagamento);

		System.out.println(balancoEmpresa.toString());
		bd.desconectar();
	}
}
