package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class TestaLeitura {

        // ------------------------------------------------------------
        // ->> Stream : Binário -> Imagem, PDF, etc ... <<-
        // ->> Reader : Caracteres -> Texto ... <<-
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        // ->> Decorator Pattern <<- Embrulhando um comportamento
        // ------------------------------------------------------------
        // new BufferedReader(
        //   new InputStreamReader(
        //     new FileInputStream("java-io/lorem.txt")
        //   )
        // );
        // ------------------------------------------------------------

        // ------------------------------------------------------------
        // ->> Adapter Pattern <<- Convertendo interfaces
        // ------------------------------------------------------------
        // InputStream -> InputStreamReader -> Reader
        // ------------------------------------------------------------

    public static void main(final String[] args) throws IOException {       

        // ************************************************************
        // -> Entrada de arquivo
        final InputStream fis = new FileInputStream("java-io/lorem.txt");
    	//final InputStream fis = new FileInputStream("lorem.txt");

        // -> Leitor que transforma bits/bytes em caracteres.
        final Reader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        // -> Classe que gera uma linha
        final BufferedReader br = new BufferedReader(isr);

        // OBS.: O método readLine devolve null quando não existe mais nenhum conteúdo a ser lido.
        String linha = br.readLine();
        while (linha != null) {
            System.out.println(linha);
            linha = br.readLine();
        }

        // -> Este br.close() fecha automaticamente: BufferedReader, InputStreamReader e
        // FileInputStream
        br.close();
    }
}