package ocp_dip.test;

import ocp_dip.model.CalculadoraDePrecos;
import ocp_dip.model.Compra;
import ocp_dip.model.Frete;
import ocp_dip.model.Entrega;
import ocp_dip.model.TabelaDePreco;
import ocp_dip.model.TabelaDePrecoPadrao;

public class TesteCalculadoraDePrecos {

    public static void main(final String[] args) {
        final TabelaDePreco tabela = new TabelaDePrecoPadrao();
        final Entrega correios = new Frete();
        final CalculadoraDePrecos calculadora = new CalculadoraDePrecos(tabela, correios);

        final Compra compra = new Compra(3000, "São Paulo");        
        final double valorCompra = calculadora.calcula(compra);

        System.out.println();
        System.out.println("Valor da compra: " + valorCompra);
    }
}