package chainOfResponsibility.model;

import strategy.investimentos.model.Conta;

public class RespostaNoFormatoXml implements Resposta {
	private Resposta proximaResposta;

	public RespostaNoFormatoXml(Resposta proximaResposta) {
		this.proximaResposta = proximaResposta;
	}

	@Override
	public void responder(Requisicao requisicao, Conta conta) {
		if (requisicao.getFormato().equals(FormatoDaConta.XML)) {
			System.out.println("<conta><titular>" + conta.getTitular() + "</titular><saldo>" + conta.getSaldo() + "</saldo></conta>");
		} else {
			this.proximaResposta.responder(requisicao, conta);
		}
	}
}
