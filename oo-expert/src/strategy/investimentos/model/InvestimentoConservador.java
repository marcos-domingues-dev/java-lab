package strategy.investimentos.model;

public class InvestimentoConservador implements TipoInvestimento {
	@Override
	public double investir(Conta conta) {
		return conta.getSaldo() * 0.008;
	}
}
