package encapsulation.model;

import java.util.List;
import coupling.model.Fatura;

public class ProcessadorDeBoletos {

    public void processa(final List<Boleto> boletos, final Fatura fatura) {       
        for (final Boleto boleto : boletos) {
            final Pagamento pagamento = new Pagamento(boleto.getValor(), MeioDePagamento.BOLETO);
            fatura.adicionarPagamento(pagamento);            
        }
    }
}