package test;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TestaEscrita {

    public static void main(final String[] args) throws IOException {

        // ------------------------------------------------------------
        // ->> Stream : Binário -> Imagem, PDF, etc ... <<-
        // ->> Writer : Caracteres -> Texto ... <<-
        // ------------------------------------------------------------

        // -> Saída de arquivo
        final OutputStream fos = new FileOutputStream("java-io/lorem2.txt");

        // -> Escritor que transforma caracteres em bits/bytes.
        final Writer osw = new OutputStreamWriter(fos);

        // -> Classe que gera uma linha
        final BufferedWriter bw = new BufferedWriter(osw);

        // String é uma CharSequence
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");
        bw.newLine();
        bw.write("quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo");
        bw.newLine();
        bw.write("consequat. Duis aute irure dolor in reprehenderit in voluptate velit");
        bw.newLine();
        bw.write("esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat");
        bw.newLine();
        bw.write("cupidatat non proident, sunt in culpa qui officia deserunt mollit anim");
        bw.newLine();
        bw.write("id est laborum.");

        // -> Este br.close() fecha automaticamente: BufferedWriter, OutputStreamWriter
        // e FileOutputStream
        bw.close();
    }
}