package lsp_inheritance.test;

import java.util.Arrays;
import java.util.List;

import lsp_inheritance.model.ContaComum;
import lsp_inheritance.model.ContaDeEstudamte;

public class ProcessadorDeInvestimentos {

    public static void main(final String[] args) {
        for (final ContaComum conta : ContasDoBanco()) {
            conta.rende();

            System.out.println("Novo saldo: " + conta.getSaldo());
        }
    }

    private static List<ContaComum> ContasDoBanco() {
        return Arrays.asList(umaContaCom(100), umaContaCom(150), contaDeEstudante(200));
    }

    private static ContaComum contaDeEstudante(final double amount) {
        final ContaDeEstudamte c = new ContaDeEstudamte();
        c.deposita(amount);
        return c;
    }

    private static ContaComum umaContaCom(final double amount) {
        final ContaComum c = new ContaComum();
        c.deposita(amount);
        return c;
    }
}