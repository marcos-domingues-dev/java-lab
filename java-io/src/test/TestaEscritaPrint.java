package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestaEscritaPrint {

    public static void main(final String[] args) throws IOException {        
        runPrintStream();
        runPrintWriter();
    }

    private static void runPrintWriter() throws FileNotFoundException {
        // -> O PrintWriter é uma classe de mais alto nível
        PrintWriter pw = new PrintWriter("java-io/TestaEscritaPrintWriter.txt");
        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.println();
        pw.print("id est laborum.");
        pw.close();
    }

    private static void runPrintStream() throws FileNotFoundException {
        // -> O PrintStream é uma classe de mais alto nível
        PrintStream ps = new PrintStream("java-io/TestaEscritaPrintStream.txt");
        ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
        ps.print("id est laborum.");
        ps.close();
    }
}