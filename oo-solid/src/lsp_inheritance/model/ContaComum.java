package lsp_inheritance.model;

public class ContaComum {
    private ManipuladorDeSaldo manipulador;

    public ContaComum() {
        this.manipulador = new ManipuladorDeSaldo();
    }

    public void deposita(double valor) {
        this.manipulador.depositar(valor);
    }

    public void saca(double valor) {
        this.manipulador.sacar(valor);
    }

    public void rende() {
        this.manipulador.render();
    }

    public double getSaldo() {
        return this.manipulador.getSaldo();
    }
}
