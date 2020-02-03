package br.com.alura.leilao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestaAvaliadorLeilao {

    @Test
    public void deveVerificarMaiorEMenorLance() {

        // 1 - Cenário : três lances (Given)
        final Usuario joao = new Usuario("João");
        final Usuario jose = new Usuario("José");
        final Usuario maria = new Usuario("Maria");

        final Leilao leilao = new Leilao("Guitarra Les Paul");
        leilao.propoe(new Lance(maria, 2100));
        leilao.propoe(new Lance(joao, 1500));
        leilao.propoe(new Lance(jose, 1900));
        leilao.propoe(new Lance(maria, 2200));
        leilao.propoe(new Lance(joao, 2700));
        leilao.propoe(new Lance(jose, 3200));

        // 2 - Executando a ação (When)
        final AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);

        // 3 - Verificando a saída (Then)
        final Double maiorEsperado = 3200.0;
        final Double menorEsperado = 1500.0;
        final Double mediaEsperada = (2100.0 + 1500.0 + 1900.0 + 2200.0 + 2700.0 + 3200.0) / 6;

        // A ordem é sempre (esperado, calculado).
        // expected 10, but was 20
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperada, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveVerificarMaiorEMenorLanceEmOrdemDecrescente() {

        // 1 - Cenário : três lances
        final Usuario joao = new Usuario("João");
        final Usuario jose = new Usuario("José");
        final Usuario maria = new Usuario("Maria");

        final Leilao leilao = new Leilao("Guitarra Les Paul");
        leilao.propoe(new Lance(jose, 3200));
        leilao.propoe(new Lance(joao, 2700));
        leilao.propoe(new Lance(maria, 2200));
        leilao.propoe(new Lance(maria, 2100));
        leilao.propoe(new Lance(jose, 1900));
        leilao.propoe(new Lance(joao, 1500));

        // 2 - Executando a ação
        final AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);

        // 3 - Verificando a saída
        final Double maiorEsperado = 3200.0;
        final Double menorEsperado = 1500.0;
        final Double mediaEsperada = (2100.0 + 1500.0 + 1900.0 + 2200.0 + 2700.0 + 3200.0) / 6;

        // A ordem é sempre (esperado, calculado).
        // expected 10, but was 20
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        assertEquals(mediaEsperada, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveTerMediaZerada() {
        // 1 - Cenário
        Leilao leilao = new Leilao("Bike Caloi");
        
        // 2 - Ação
        AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);

        // 3 - Verificar
        assertEquals(0, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveTerNenhumLance() {
        // Cenário
        final Leilao leilao = new Leilao("Playstation 4");

        // 2 - Ação
        AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);
        
        // 3 - Verificar
        double maiorEsperado = Double.NEGATIVE_INFINITY;
        double menorEsperado = Double.POSITIVE_INFINITY;  
        assertEquals(0, leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerApenasUmLance() {
        // Cenário
        final Usuario rapunzel = new Usuario("Rapunzel");
        final Leilao leilao = new Leilao("Playstation 4");
        leilao.propoe(new Lance(rapunzel, 100));

        // 2 - Ação
        AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);
        
        // 3 - Verificar
        double maiorEsperado = 100;
        double menorEsperado = 100;
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerDoisLances() {
        // Cenário
        final Usuario rapunzel = new Usuario("Rapunzel");
        final Usuario jose = new Usuario("José");
        final Leilao leilao = new Leilao("Playstation 4");

        leilao.propoe(new Lance(rapunzel, 100));
        leilao.propoe(new Lance(jose, 120));

        // 2 - Ação
        AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);
        
        // 3 - Verificar
        double maiorEsperado = 120;
        double menorEsperado = 100;
        assertEquals(2, leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveTerOsTresMaiores() {
        // Cenário
        final Usuario rapunzel = new Usuario("Rapunzel");
        final Usuario jose = new Usuario("José");

        final Leilao leilao = new Leilao("XBox One");
        leilao.propoe(new Lance(jose, 1900));
        leilao.propoe(new Lance(rapunzel, 2100));
        leilao.propoe(new Lance(jose, 2500));
        leilao.propoe(new Lance(rapunzel, 2700));        

        // 2 - Ação
        AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);

        // 3 - Verificar
        assertEquals(3, leiloeiro.getTresMaiores().size(), 0.00001);
        assertEquals(2700L, leiloeiro.getTresMaiores().get(0).getValor(), 0.0001);
        assertEquals(2500L, leiloeiro.getTresMaiores().get(1).getValor(), 0.0001);
        assertEquals(2100L, leiloeiro.getTresMaiores().get(2).getValor(), 0.0001);
    }

}