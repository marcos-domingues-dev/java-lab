package strategy.investimentos.test;

import java.text.NumberFormat;
import java.util.Locale;

import strategy.investimentos.model.Conta;
import strategy.investimentos.model.InvestimentoArrojado;
import strategy.investimentos.model.InvestimentoConservador;
import strategy.investimentos.model.InvestimentoModerado;
import strategy.investimentos.model.RealizadorDeInvestimentos;
import strategy.investimentos.model.TipoInvestimento;

public class TestaRealizadorDeInvestimentos {

	public static void main(String[] args) {
		NumberFormat formatadorDeNumeros = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		RealizadorDeInvestimentos realizadorDeInvestimentos = new RealizadorDeInvestimentos(formatadorDeNumeros);
		Conta conta = new Conta();

		TipoInvestimento investimentoConservador = new InvestimentoConservador();
		conta.sacar(conta.getSaldo());
		conta.depositar(100);
		realizadorDeInvestimentos.aplicarRendimentos(conta, investimentoConservador);

		TipoInvestimento investimentoModerado = new InvestimentoModerado();
		conta.sacar(conta.getSaldo());
		conta.depositar(100);
		realizadorDeInvestimentos.aplicarRendimentos(conta, investimentoModerado);

		TipoInvestimento investimentoArrojado = new InvestimentoArrojado();
		conta.sacar(conta.getSaldo());
		conta.depositar(100);
		realizadorDeInvestimentos.aplicarRendimentos(conta, investimentoArrojado);
	}
}
