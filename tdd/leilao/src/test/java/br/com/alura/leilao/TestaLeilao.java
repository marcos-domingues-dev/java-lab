package br.com.alura.leilao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestaLeilao {
    private Usuario steveJobs;
    private Usuario billGates;
    private Usuario magnata;

    @Before
    public void setup() {
        this.steveJobs = new Usuario("Steve Jobs");
        this.billGates = new Usuario("Bill Gates");
         this.magnata = new Usuario("Magnata do Petroleo");
    }

    @Test
    public void deveReceber1Lance() {
        final Leilao leilao = new LeilaoBuilder().para("Macbook Pro 15").lance(steveJobs, 2000).pegar();

        final int quantidadeEsperada = 1;
        assertEquals(quantidadeEsperada, leilao.getLances().size());
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LanesDeUmMesmoUsuario() {
        final Leilao leilao = new LeilaoBuilder().para("Macbook Pro 15").lance(steveJobs, 2000).lance(billGates, 2500)
                .lance(steveJobs, 3000).lance(billGates, 3500).lance(steveJobs, 4000).lance(billGates, 4500)
                .lance(steveJobs, 5000).lance(billGates, 5500).lance(steveJobs, 6000).lance(billGates, 6500).pegar();

        leilao.propoe(new Lance(steveJobs, 6000));

        final int quantidadeEsperada = 10;
        assertEquals(quantidadeEsperada, leilao.getLances().size());
    }

    @Test
    public void deveDobrarOLanceDoUsuario() {
        final Leilao leilao = new LeilaoBuilder().para("Terreno no estado do Texas.").lance(magnata, 100)
            .lance(magnata, 100)
            .lance(billGates, 150)
            .pegar();
        leilao.dobrarUltimoLance(magnata);

        final double valorEsperadoEmDobro = 200;
        assertEquals(valorEsperadoEmDobro, leilao.getValorUltimoLanceDo(magnata), 0.00001);
    }

    @Test
    public void naoDeveDobrarCasoNaoTenhaLanceAnteriorDoUsuario() {
        final Leilao leilao = new LeilaoBuilder().para("Terreno no estado do Texas.")
            .lance(billGates, 150)
            .pegar();
        leilao.dobrarUltimoLance(magnata);

        final double valorEsperadoEmDobro = 0;
        assertEquals(valorEsperadoEmDobro, leilao.getValorUltimoLanceDo(magnata), 0.00001);
    }
}