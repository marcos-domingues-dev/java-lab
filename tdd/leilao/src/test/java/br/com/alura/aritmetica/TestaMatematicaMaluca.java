package br.com.alura.aritmetica;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestaMatematicaMaluca {

    @Test
    public void deveCalcularValorZerado() {
        // 1 - Given (Cenário)
        MatematicaMaluca m = new MatematicaMaluca();
        // 2 - When (Ação)
        int valorCalculado = m.contaMaluca(0);
        // 2 - Then (verificar)
        int valorEsperado = 0;
        assertEquals(valorEsperado, valorCalculado, 0.0001);
    }

    @Test
    public void deveCalcularValorMaiorQue30() {
        // 1 - Given (Cenário)
        MatematicaMaluca m = new MatematicaMaluca();
        // 2 - When (Ação)
        int valorCalculado = m.contaMaluca(40);
        // 2 - Then (verificar)
        int valorEsperado = 40 * 4;
        assertEquals(valorEsperado, valorCalculado, 0.0001);
    }

    @Test
    public void deveCalcularValorMaiorQue10EMenorOuIgualA30() {
        // 1 - Given (Cenário)
        MatematicaMaluca m = new MatematicaMaluca();
        // 2 - When (Ação)
        int valorCalculado = m.contaMaluca(12);
        // 2 - Then (verificar)
        int valorEsperado = 12 * 3;
        assertEquals(valorEsperado, valorCalculado, 0.0001);
    }

    @Test
    public void deveCalcularValorMenorOuIgualA10() {
        // 1 - Given (Cenário)
        MatematicaMaluca m = new MatematicaMaluca();
        // 2 - When (Ação)
        int valorCalculado = m.contaMaluca(10);
        // 2 - Then (verificar)
        int valorEsperado = 10 * 2;
        assertEquals(valorEsperado, valorCalculado, 0.0001);
    }
}