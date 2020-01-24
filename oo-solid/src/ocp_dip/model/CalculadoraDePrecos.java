package ocp_dip.model;

public class CalculadoraDePrecos {

    public double calcula(final Compra produto) {
        final TabelaDePrecoPadrao tabela = new TabelaDePrecoPadrao();
        final Frete correios = new Frete();

        final double desconto = tabela.descontoPara(produto.getValor());
        final double frete = correios.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }

}