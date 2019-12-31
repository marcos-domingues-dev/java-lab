package chainOfResponsibility.model;

import strategy.investimentos.model.Conta;

public class RespostaNoFormatoPorcento implements Resposta {
	private Resposta proximaResposta;

	public RespostaNoFormatoPorcento(Resposta proximaResposta) {
		this.proximaResposta = proximaResposta;
	}

	@Override
	public void responder(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(FormatoDaConta.PORCENTO)) {
			System.out.println(conta.getTitular() + "%" + conta.getSaldo());
		} else {
			if (this.proximaResposta != null) {
				this.proximaResposta.responder(requisicao, conta);
			} else {
				throw new RuntimeException("Formato de resposta não encontrado");
			}
		}
	}
}
