package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TestaLerDoTeclado {

    public static void main(final String[] args) throws IOException {

        // ------------------------------------------------------------
        // -> Para ler da Rede <-
        // final Socket s  = new Socket();
        // final InputStream fis = s.getInputStream();
        // final OutputStream fos = s.getOutputStream();
        // ------------------------------------------------------------

        // -> Entrada do arquivo
        final InputStream fis = System.in; // -> Lendo do console ...
        final Reader isr = new InputStreamReader(fis);
        final BufferedReader br = new BufferedReader(isr);

        // -> Saída de arquivo
        //final OutputStream fos = System.out; // -> Saída no console
        final OutputStream fos = new FileOutputStream("java-io/lorem_teclado.txt");        
        final Writer osw = new OutputStreamWriter(fos);        
        final BufferedWriter bw = new BufferedWriter(osw);        

        String linha = br.readLine();
        while (linha != null && !linha.isEmpty()) {
            bw.write(linha);
            bw.newLine();
            //bw.flush();; //-> Envia no mesmo instante de escrita para a saída (console) ...
            linha = br.readLine();
        }

        bw.close();
        br.close();
    }
}