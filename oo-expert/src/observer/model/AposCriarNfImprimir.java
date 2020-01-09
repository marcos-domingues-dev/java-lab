package observer.model;

import builder.model.NotaFiscal;

public class AposCriarNfImprimir implements AcaoAposCriarNf {

	@Override
	public void executar(NotaFiscal nf) {
		System.out.println("Imprimirndo NF...");
	}

}
