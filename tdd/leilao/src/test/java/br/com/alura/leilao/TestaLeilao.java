package br.com.alura.leilao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestaLeilao {

    @Test
    public void deveReceber1Lance() {
        // given
        Usuario steveJobs = new Usuario("Steve Jobs");
        Leilao leilao = new Leilao("Macbook Pro 15");

        // when
        leilao.propoe(new Lance(steveJobs, 2000));

        // then
        int quantidadeEsperada = 1;
        assertEquals(quantidadeEsperada, leilao.getLances().size());
    }

    @Test
    public void naoDeveAceitarMaisDoQue5LanesDeUmMesmoUsuario() {
        // given
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");
        Leilao leilao = new Leilao("Macbook Pro 15");

        // when
        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(billGates, 2500));
        
        leilao.propoe(new Lance(steveJobs, 3000));
        leilao.propoe(new Lance(billGates, 3500));

        leilao.propoe(new Lance(steveJobs, 4000));
        leilao.propoe(new Lance(billGates, 4500));

        leilao.propoe(new Lance(steveJobs, 5000));
        leilao.propoe(new Lance(billGates, 5500));

        leilao.propoe(new Lance(steveJobs, 6000));
        leilao.propoe(new Lance(billGates, 6500));

        // deve ser ignorado
        leilao.propoe(new Lance(steveJobs, 6000));
        
        // then
        int quantidadeEsperada = 10;
        assertEquals(quantidadeEsperada, leilao.getLances().size());
    }

    @Test
    public void deveDobrarOLanceDoUsuario() {
        // guiven
        Usuario magnata = new Usuario("Magnata do Petroleo");
        Usuario billGates = new Usuario("Bill Gates");
        Leilao leilao = new Leilao("Terreno no estado do Texas.");

        // when
        leilao.propoe(new Lance(magnata, 100));
        leilao.propoe(new Lance(billGates, 150));        
        leilao.dobrarUltimoLance(magnata);

        // then
        double valorEsperadoEmDobro = 200;
        assertEquals(valorEsperadoEmDobro, leilao.getValorUltimoLanceDo(magnata), 0.00001);
    }

    @Test
    public void naoDeveDobrarCasoNaoTenhaLanceAnteriorDoUsuario() {
        // guiven
        Usuario magnata = new Usuario("Magnata do Petroleo");
        Usuario billGates = new Usuario("Bill Gates");
        Leilao leilao = new Leilao("Terreno no estado do Texas.");

        // when
        leilao.propoe(new Lance(billGates, 150));        
        leilao.dobrarUltimoLance(magnata);

        // then
        double valorEsperadoEmDobro = 0;
        assertEquals(valorEsperadoEmDobro, leilao.getValorUltimoLanceDo(magnata), 0.00001);
    }
}