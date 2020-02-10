package br.com.alura.leilao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaAvaliadorLeilao {

    private AvaliadorLeilao leiloeiro;
    private Usuario joao = new Usuario("João");
    private Usuario jose = new Usuario("José");
    private Usuario maria = new Usuario("Maria");
    private Usuario rapunzel = new Usuario("Rapunzel");

    @Before
    public void Setup() {
        this.leiloeiro = new AvaliadorLeilao();
    }

    // @After
    // public void finaliza() {
    //     //System.out.println("fim");
    // }

    @Test
    public void deveVerificarMaiorEMenorLance() {

        // 1 - Cenário : três lances (Given)
        final Leilao leilao = new LeilaoBuilder().para("Guitarra Les Paul")
            .lance(maria, 2100)
            .lance(joao, 1500)
            .lance(jose, 1900)
            .lance(maria, 2200)
            .lance(joao, 2700)
            .lance(jose, 3200)
            .pegar();

        // 2 - Executando a ação (When)
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificando a saída (Then)
        final Double maiorEsperado = 3200.0;
        final Double menorEsperado = 1500.0;
        final Double mediaEsperada = (2100.0 + 1500.0 + 1900.0 + 2200.0 + 2700.0 + 3200.0) / 6;

        // A ordem é sempre (esperado, calculado).
        // expected 10, but was 20
        assertEquals(maiorEsperado, this.leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, this.leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperada, this.leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveVerificarMaiorEMenorLanceEmOrdemDecrescente() {

        // 1 - Cenário : três lances
        final Leilao leilao = new LeilaoBuilder().para("Guitarra Les Paul")
            .lance(jose, 3200)
            .lance(joao, 2700)
            .lance(maria, 2200)
            .lance(maria, 2100) // -- >> Barrado pelas regras (Dois lances em sequência)
            .lance(jose, 1900)
            .lance(joao, 1500)
            .pegar();

        // 2 - Executando a ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificando a saída
        final Double maiorEsperado = 3200.0;
        final Double menorEsperado = 1500.0;
        final Double mediaEsperada = (1500.0 + 1900.0 + 2200.0 + 2700.0 + 3200.0) / 5;

        // A ordem é sempre (esperado, calculado).
        // expected 10, but was 20
        assertEquals(maiorEsperado, this.leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, this.leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperada, this.leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveTerMediaZerada() {
        // 1 - Cenário
        final Leilao leilao = new Leilao("Bike Caloi");

        // 2 - Ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificar
        assertEquals(0, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveTerNenhumLance() {
        // Cenário
        final Leilao leilao = new Leilao("Playstation 4");

        // 2 - Ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificar
        final double maiorEsperado = Double.NEGATIVE_INFINITY;
        final double menorEsperado = Double.POSITIVE_INFINITY;
        assertEquals(0, this.leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(maiorEsperado, this.leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, this.leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerApenasUmLance() {
        // Cenário
        final Leilao leilao = new LeilaoBuilder().para("Playstation 4")
            .lance(rapunzel, 100)
            .pegar();

        // 2 - Ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificar
        final double maiorEsperado = 100;
        final double menorEsperado = 100;
        assertEquals(maiorEsperado, this.leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, this.leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerDoisLances() {
        // Cenário
        final Leilao leilao = new LeilaoBuilder().para("Playstation 4")
            .lance(rapunzel, 100)
            .lance(jose, 120)
            .pegar();

        // 2 - Ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificar
        final double maiorEsperado = 120;
        final double menorEsperado = 100;
        assertEquals(2, this.leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(maiorEsperado, this.leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, this.leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerOsTresMaiores() {
        // Cenário
        final Leilao leilao =  new LeilaoBuilder().para("XBox One")
            .lance(jose, 1900)
            .lance(rapunzel, 2100)
            .lance(jose, 2500)
            .lance(rapunzel, 2700)
            .pegar();

        // 2 - Ação
        this.leiloeiro.Verificar(leilao);

        // 3 - Verificar
        assertEquals(3, this.leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(2700L, this.leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
        assertEquals(2500L, this.leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
        assertEquals(2100L, this.leiloeiro.getTresMaiores().get(2).getValor(), 0.0001);
    }

}