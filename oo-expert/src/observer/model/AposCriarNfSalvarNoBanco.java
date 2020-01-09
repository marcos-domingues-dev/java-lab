package observer.model;

import builder.model.NotaFiscal;

public class AposCriarNfSalvarNoBanco implements AcaoAposCriarNf {

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Salvando no banco de dados...");
	}

}
