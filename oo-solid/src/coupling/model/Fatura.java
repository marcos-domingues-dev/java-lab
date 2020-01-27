package coupling.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import encapsulation.model.Pagamento;

public class Fatura {
    private double valorMensal;
    private String cliente;
    private final List<Pagamento> pagamentos = new ArrayList<Pagamento>();
    private boolean pago;
    double total = 0;

    public Fatura() {
    }

    public boolean isPago() {
        return pago;
    }

    public Fatura(final double valorMensal, final String cliente) {
        this.valorMensal = valorMensal;
        this.cliente = cliente;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public String getCliente() {
        return cliente;
    }

    public void adicionarPagamento(final Pagamento pagamento) {
        this.pagamentos.add(pagamento);

        total += pagamento.getValor();
        if (total >= this.valorMensal) {
            this.pago = true;
        }        
    }
    
    public List<Pagamento> getPagamentos()  {
        return Collections.unmodifiableList(pagamentos);
    }
}
