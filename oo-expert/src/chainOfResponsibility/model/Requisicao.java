package chainOfResponsibility.model;

public class Requisicao {
	private FormatoDaConta formato;
	
	public Requisicao(FormatoDaConta formato) {
		this.formato = formato;
	}

	public FormatoDaConta getFormato() {
		return formato;
	}
}
