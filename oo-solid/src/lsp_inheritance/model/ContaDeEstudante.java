package lsp_inheritance.model;

public class ContaDeEstudante {
    private ManipuladorDeSaldo manipulador;
    private int milhas;

    public int getMilhas() {
        return milhas;
    }

    public ContaDeEstudante() {
        this.manipulador = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
        this.manipulador.depositar(valor);
        this.milhas += (int) valor;
    }

    public void saca(double valor) {
        this.manipulador.sacar(valor);
    }

    public double getSaldo() {
        return this.manipulador.getSaldo();
    }

}
