package strategy.investimentos.model;

import java.util.Random;

public class InvestimentoArrojado implements TipoInvestimento {
	private Random random;

	public InvestimentoArrojado() {
		this.random = new Random();
	}

	@Override
	public double investir(Conta conta) {
		int chute = this.random.nextInt(10);
		if (chute >= 0 && chute <= 1) {
			return conta.getSaldo() * 0.05;
		} else if (chute >= 2 && chute <= 4) {
			return conta.getSaldo() * 0.03;
		}
		return conta.getSaldo() * 0.006;
	}
}
