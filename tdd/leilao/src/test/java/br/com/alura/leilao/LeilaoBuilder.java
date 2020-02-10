package br.com.alura.leilao;

public class LeilaoBuilder {

    Leilao leilao;

    public LeilaoBuilder () { }

    public LeilaoBuilder para(final String descricao) {
        this.leilao = new Leilao(descricao);
        return this;
    }

    public LeilaoBuilder lance(final Usuario usuario, final double valor) {
        final Lance lance = new Lance(usuario, valor);
        this.leilao.propoe(lance);
        return this;
    }

    public Leilao pegar() {
        return this.leilao;
    }

}