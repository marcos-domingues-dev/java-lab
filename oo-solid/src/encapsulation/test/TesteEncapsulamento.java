package encapsulation.test;

import java.util.ArrayList;
import java.util.List;

import coupling.model.Fatura;
import encapsulation.model.Boleto;
import encapsulation.model.ProcessadorDeBoletos;

public class TesteEncapsulamento {

    public static void main(final String[] args) {
        final Fatura fatura = new Fatura(500, "Hell Boy");

        final List<Boleto> boletos = new ArrayList<Boleto>();
        boletos.add(new Boleto(200));
        boletos.add(new Boleto(180));
        boletos.add(new Boleto(100));

        final ProcessadorDeBoletos processador = new ProcessadorDeBoletos();
        processador.processa(boletos, fatura);

        System.out.println("Fatura está paga ? " + fatura.isPago());
    }
}