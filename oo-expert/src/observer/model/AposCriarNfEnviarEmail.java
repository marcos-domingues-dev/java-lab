package observer.model;

import builder.model.NotaFiscal;

public class AposCriarNfEnviarEmail implements AcaoAposCriarNf {

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Enviando email...");
	}

}
