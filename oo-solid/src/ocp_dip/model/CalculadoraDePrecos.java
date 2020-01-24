package ocp_dip.model;

public class CalculadoraDePrecos {

    final private TabelaDePreco tabela;
    private Entrega entrega;

    public CalculadoraDePrecos(final TabelaDePreco tabela, final Entrega entrega) {
        this.tabela = tabela;
        this.entrega = entrega;
    }

    public double calcula(final Compra produto) {
        final double desconto = tabela.descontoPara(produto.getValor());
        final double frete = entrega.para(produto.getCidade());

        return produto.getValor() * (1-desconto) + frete;
    }

}