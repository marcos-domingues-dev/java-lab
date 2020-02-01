package br.com.alura.leilao;

import org.junit.Assert;
import org.junit.Test;

public class TestaAvaliadorLeilao {

    @Test
    public void deveVerificarMaiorEMenorLance() {
        
        // 1 - Cenário : três lances
        final Usuario joao = new Usuario("João");
        final Usuario jose = new Usuario("José");
        final Usuario maria = new Usuario("Maria");

        final Leilao leilao = new Leilao("Guitarra Les Paul");
        leilao.propoe(new Lance(maria, 2100));
        leilao.propoe(new Lance(joao, 1500));
        leilao.propoe(new Lance(jose, 1900));

        // 2 - Executando a ação
        final AvaliadorLeilao leiloeiro = new AvaliadorLeilao();
        leiloeiro.Verificar(leilao);

        // 3 - Verificando a saída
        final Double maiorEsperado = 2100.0;
        final Double menorEsperado = 1500.0;
        final Double mediaEsperada = (2100.0 + 1500.0 + 1900.0) / 3;

        // A ordem é sempre (esperado, calculado).
        // expected 10, but was 20
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
        Assert.assertEquals(mediaEsperada, leiloeiro.getMedia(), 0.00001);
    }

    @Test
    public void deveTerMediaZerada() {
        // 1 - Cenário
        Leilao leilao = new Leilao("Bike Caloi");
        
        // 2 - Ação
        AvaliadorLeilao avaliador = new AvaliadorLeilao();
        avaliador.Verificar(leilao);

        // 3 - Verificar
        Assert.assertEquals(0, avaliador.getMedia(), 0.00001);
    }

}