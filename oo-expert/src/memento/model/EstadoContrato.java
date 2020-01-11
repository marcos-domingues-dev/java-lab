package memento.model;

public class EstadoContrato {
	private Contrato contrato;

	public EstadoContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Contrato getContrato() {
		return contrato;
	}
	
}
