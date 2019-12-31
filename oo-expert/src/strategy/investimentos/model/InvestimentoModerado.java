package strategy.investimentos.model;

import java.util.Random;

public class InvestimentoModerado implements TipoInvestimento {
	private Random random;

	public InvestimentoModerado() {
		this.random = new Random();
	}

	@Override
	public double investir(Conta conta) {
		if (this.random.nextInt(2) == 0) {
			return conta.getSaldo() * 0.007;
		}
		return conta.getSaldo() * 0.025;
	}
}
