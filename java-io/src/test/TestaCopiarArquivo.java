package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TestaCopiarArquivo {

    public static void main(final String[] args) throws IOException {

        // -> Entrada do arquivo
        final InputStream fis = new FileInputStream("java-io/lorem.txt");
        final Reader isr = new InputStreamReader(fis);
        final BufferedReader br = new BufferedReader(isr);

        // -> Saída de arquivo
        final OutputStream fos = new FileOutputStream("java-io/lorem_copy.txt");
        final Writer osw = new OutputStreamWriter(fos);        
        final BufferedWriter bw = new BufferedWriter(osw);        

        String linha = br.readLine();
        while (linha != null) {
            bw.write(linha);
            bw.newLine();
            linha = br.readLine();
        }

        bw.close();
        br.close();
    }
}