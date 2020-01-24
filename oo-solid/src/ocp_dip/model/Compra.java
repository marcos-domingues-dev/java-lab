package ocp_dip.model;

public class Compra {
    private final double valor;
    private final String cidade;

    public Compra(final double valor, final String cidade) {
        this.valor = valor;
        this.cidade = cidade;
    }

    public double getValor() {
        return valor;
    }

    public String getCidade() {
        return cidade;
    }
}
