package ocp_dip.test;

import ocp_dip.model.CalculadoraDePrecos;
import ocp_dip.model.Compra;

public class TesteCalculadoraDePrecos {

    public static void main(final String[] args) {
        final CalculadoraDePrecos calculadora = new CalculadoraDePrecos();
        Compra produto = new Compra(3000, "São Paulo");
        
        final double valorCompra = calculadora.calcula(produto);

        System.out.println();
        System.out.println("Valor da compra: " + valorCompra);
    }
}