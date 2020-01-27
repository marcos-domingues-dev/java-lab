package encapsulation.model;

public class Boleto {

    private final double valor;

    public Boleto(final double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }
}
