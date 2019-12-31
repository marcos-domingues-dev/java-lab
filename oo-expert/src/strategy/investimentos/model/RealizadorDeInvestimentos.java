package strategy.investimentos.model;

import java.text.NumberFormat;

public class RealizadorDeInvestimentos {
	
	private NumberFormat formatadorDeNumeros;

	public RealizadorDeInvestimentos(NumberFormat formatadorDeNumeros) {
		this.formatadorDeNumeros = formatadorDeNumeros;
	}
	
	public void aplicarRendimentos(Conta conta, TipoInvestimento tipoInvestimento) {
		double valorRendimento = tipoInvestimento.investir(conta);
		double valorImposto = valorRendimento * 0.25;
		valorRendimento -= valorImposto;
		conta.depositar(valorRendimento);

		String valorFormatado = formatadorDeNumeros.format(conta.getSaldo());
		System.out.println(valorFormatado);
	}
}
