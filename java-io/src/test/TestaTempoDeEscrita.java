package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestaTempoDeEscrita {

    public static void main(String[] args)  throws IOException {
        long msInicial = System.currentTimeMillis();

        BufferedWriter bw = new BufferedWriter(new FileWriter("java-io/TestaTempoDeEscrita.txt"));
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bw.newLine();
        bw.write("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam");
        bw.close();

        long msFinal = System.currentTimeMillis();

        System.out.println("Passaram " + (msFinal - msInicial) + " milisegundos.");
        
        
    }
}