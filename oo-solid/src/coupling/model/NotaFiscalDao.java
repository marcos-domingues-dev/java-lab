package coupling.model;

public class NotaFiscalDao implements AcaoAposGerarNf {

	@Override
	public void executar(NotaFiscal notaFiscal) {
		System.out.println("salva nf no banco");
	}
}
