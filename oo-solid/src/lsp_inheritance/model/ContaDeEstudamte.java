package lsp_inheritance.model;

public class ContaDeEstudamte extends ContaComum {
    private int milhas;

    public void deposita(double valor) {
        super.deposita(valor);
        this.milhas += (int) valor;
    }

    public int getMilhas() {
        return milhas;
    }

    @Override
    public void rende() {
        throw new RuntimeException("Conta de estudante não pode render");
    }

}
