package teste;

import java.util.Collection;

import modelo.BalancoEmpresa;
import modelo.BancoDeDados;
import modelo.Cnpj;
import modelo.Divida;
import modelo.Pagamento;
import modelo.Pagamentos;

public class TestaFinanceiro {

	public static void main(String[] args) {
		TestaFinanceiro t = new TestaFinanceiro();
		t.testaBalanco();
		t.testaPagtos();
		t.testaPagtosDoPagador();
	}

	private void testaBalanco() {
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

		balancoEmpresa.pagaDivida(cnpjCredor, pagamento);

		System.out.println(balancoEmpresa.toString());
	}

	private void testaPagtos() {
		Pagamentos s = new Pagamentos();

		Cnpj cnpjPagador = new Cnpj("123");

		Pagamento p = new Pagamento(cnpjPagador);
		p.setValor(50);
		s.registra(p);

		Pagamento p2 = new Pagamento(cnpjPagador);
		p2.setValor(1500);
		s.registra(p2);

		Pagamento p3 = new Pagamento(cnpjPagador);
		p3.setValor(350);
		s.registra(p3);

		Pagamento p4 = new Pagamento(cnpjPagador);
		p4.setValor(5);
		s.registra(p4);

		Pagamento p5 = new Pagamento(cnpjPagador);
		p5.setValor(3);
		s.registra(p5);

		Collection<Pagamento> vMaior = s.pagamentosComValorMaiorQue(300);
		for (Pagamento item : vMaior) {
			System.out.println(item.toString());
		}
	}

	private void testaPagtosDoPagador() {
		Pagamentos s = new Pagamentos();

		Cnpj cnpjPagador1 = new Cnpj("003");
		Cnpj cnpjPagador2 = new Cnpj("007");

		Pagamento p = new Pagamento(cnpjPagador1);
		p.setValor(50);
		s.registra(p);

		Pagamento p2 = new Pagamento(cnpjPagador1);
		p2.setValor(1500);
		s.registra(p2);

		Pagamento p3 = new Pagamento(cnpjPagador1);
		p3.setValor(350);
		s.registra(p3);

		Pagamento p4 = new Pagamento(cnpjPagador2);
		p4.setValor(5);
		s.registra(p4);

		Pagamento p5 = new Pagamento(cnpjPagador2);
		p5.setValor(3);
		s.registra(p5);

		Collection<Pagamento> vMaior = s.pagamentosDo(cnpjPagador2);
		for (Pagamento item : vMaior) {
			System.out.println(item.toString());
		}
	}

}
