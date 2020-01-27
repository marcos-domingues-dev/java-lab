package encapsulation.model;

public class Pagamento {
    private final double valor;
    private final MeioDePagamento meioDePagto;

    public Pagamento(final double valor, final MeioDePagamento meioDePagto) {
        this.valor = valor;
        this.meioDePagto = meioDePagto;
    }

    public MeioDePagamento getMeioDePagto() {
        return meioDePagto;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof Pagamento)) {
            return false;
        }

        final Pagamento outro = (Pagamento) obj;
        if (this.meioDePagto != outro.getMeioDePagto()
                || Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(outro.getValor())) {
            return false;
        }

        return true;
    }

}
