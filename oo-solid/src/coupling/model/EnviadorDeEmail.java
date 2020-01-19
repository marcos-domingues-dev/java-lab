package coupling.model;

public class EnviadorDeEmail implements AcaoAposGerarNf {

	@Override
	public void executar(NotaFiscal notaFiscal) {
		System.out.println("envia email da nf " + notaFiscal.getId());
	}
}
