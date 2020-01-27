package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestaEscritaFileWriter {

    public static void main(final String[] args) throws IOException {
        TesteSimplificado();
        TesteElaborado();
    }

    private static void TesteSimplificado() throws IOException {
        FileWriter fw = new FileWriter("java-io/TestaEscritaSimplificado.txt");
        fw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        fw.write(System.lineSeparator());
        fw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,");
        fw.write(System.lineSeparator());
        fw.write("quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo");
        fw.write(System.lineSeparator());
        fw.write("consequat. Duis aute irure dolor in reprehenderit in voluptate velit");
        fw.write(System.lineSeparator());
        fw.write("esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat");
        fw.write(System.lineSeparator());
        fw.write("cupidatat non proident, sunt in culpa qui officia deserunt mollit anim");
        fw.write(System.lineSeparator());
        fw.write("id est laborum.");
        fw.close();
    }

    private static void TesteElaborado() throws IOException {
        FileWriter fw = new FileWriter("java-io/TestaEscritaElaborado.txt");
        BufferedWriter bw = new BufferedWriter(fw);

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

        bw.close();
    }
}