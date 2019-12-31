package chainOfResponsibility.model;

import strategy.investimentos.model.Conta;

public interface Resposta {
	//void setProxima(Resposta proximaResposta);
	void responder(Requisicao requisicao, Conta conta);
}
