package chainOfResponsibility.model;

import strategy.investimentos.model.Conta;

public class RespostaNoFormatoCsv implements Resposta {
	private Resposta proximaResposta;

	public RespostaNoFormatoCsv(Resposta proximaResposta) {
		this.proximaResposta = proximaResposta;
	}

	@Override
	public void responder(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(FormatoDaConta.CSV)) {
			System.out.println(conta.getTitular() + "," + conta.getSaldo());
		} else {
			this.proximaResposta.responder(requisicao, conta);
		}
	}
}
