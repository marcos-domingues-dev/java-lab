package com.br.alura.desafio.ano;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestaAnoBissexto {

    @Test
    public void deveSerAnoBisexto() {
        // given
        AnoBissexto anoBissexto = new AnoBissexto();

        // when
        boolean resultadoAno2016 = anoBissexto.isAnoBissexto(2016);
        boolean resultadoAno2020 = anoBissexto.isAnoBissexto(2020);

        // then
        assertTrue(resultadoAno2016);
        assertTrue(resultadoAno2020);
    }

    @Test
    public void naoDeveSerAnoBisexto() {
        // given
        AnoBissexto anoBissexto = new AnoBissexto();

        // when
        boolean resultadoAno2011 = anoBissexto.isAnoBissexto(2011);
        boolean resultadoAno2015 = anoBissexto.isAnoBissexto(2015);

        // then
        assertFalse(resultadoAno2011);
        assertFalse(resultadoAno2015);
    }

}
