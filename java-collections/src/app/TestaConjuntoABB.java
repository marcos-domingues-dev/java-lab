package app;

import java.util.HashSet;
import java.util.Set;

public class TestaConjuntoABB {

    public static void main(String[] args) {
        Set<String> conjunto = new HashSet<String>();
        conjunto.add("A");
        conjunto.add("B");
        conjunto.add("B");

        System.out.println();
        conjunto.forEach(elemento -> {
            System.out.println(elemento);
        });

        System.out.println();
        System.out.println("Note que o elemento B não se repetiu.");
        System.out.println("E veja que utilizamos o forEach do conjunto.");
        System.out.println();
    }
}