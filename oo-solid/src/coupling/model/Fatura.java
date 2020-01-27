package coupling.model;

import java.util.ArrayList;
import java.util.List;

import encapsulation.model.Pagamento;

public class Fatura {
    private double valorMensal;
    private String cliente;
    private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
    private boolean pago;

    public Fatura() {
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public Fatura(double valorMensal, String cliente) {
        this.valorMensal = valorMensal;
        this.cliente = cliente;
    }
    public double getValorMensal() {
        return valorMensal;
    }
    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

	public List<Pagamento> getPagamentos() {
		return this.pagamentos;
	}
}
