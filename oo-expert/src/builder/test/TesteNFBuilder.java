package builder.test;

import java.util.ArrayList;
import java.util.List;

import builder.model.ItemDaNota;
import builder.model.NotaFiscal;
import builder.model.NotaFiscalBuilder;
import observer.model.AposCriarNfEnviarEmail;
import observer.model.AposCriarNfImprimir;
import observer.model.AcaoAposCriarNf;
import observer.model.AposCriarNfSalvarNoBanco;

public class TesteNFBuilder {

	public static void main(String[] args) {

		List<AcaoAposCriarNf> observadores = new ArrayList<AcaoAposCriarNf>();
		observadores.add(new AposCriarNfSalvarNoBanco());
		observadores.add(new AposCriarNfImprimir());
		observadores.add(new AposCriarNfEnviarEmail());

		NotaFiscal nf = new NotaFiscalBuilder(observadores)
			.paraEmpresa("Caelum")
			.comCnpj("123.456.789/0001-10")
			.comItem(new ItemDaNota("item 1", 100.0))
			.comItem(new ItemDaNota("item 2", 200.0))
			.comItem(new ItemDaNota("item 3", 300.0))
			.comObservacoes("entregar nf pessoalmente")
			.naDataAtual()
			.constroi();

		System.out.println(nf.getValorBruto());
	}
}
