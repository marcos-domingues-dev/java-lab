package chainOfResponsibility.test;

import chainOfResponsibility.model.FormatoDaConta;
import chainOfResponsibility.model.Requisicao;
import chainOfResponsibility.model.Resposta;
import chainOfResponsibility.model.RespostaNoFormatoCsv;
import chainOfResponsibility.model.RespostaNoFormatoPorcento;
import chainOfResponsibility.model.RespostaNoFormatoXml;
import strategy.investimentos.model.Conta;

public class TestaRequisicao {

	public static void main(String[] args) {
		Conta conta = new Conta("Robert C. Martin", 100); // Clean Code author

		// Chain of Responsibility:
		// Recebendo o próximo ítem da corrente pelo construtor.
		Resposta respPCent = new RespostaNoFormatoPorcento(null);
		Resposta respCsv = new RespostaNoFormatoCsv(respPCent);
		Resposta respXml = new RespostaNoFormatoXml(respCsv);

		Requisicao requisicao = new Requisicao(FormatoDaConta.CSV);
		respXml.responder(requisicao, conta);
	}
}
