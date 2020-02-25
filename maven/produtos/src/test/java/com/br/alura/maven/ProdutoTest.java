package com.br.alura.maven;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {

    @Test
    public void VerificarValorDoImposto() {
        Produto p = new Produto("Balinha", 0.10);

        assertEquals(0.11, p.getValorComImposto(), 0.00001);
    } 

}