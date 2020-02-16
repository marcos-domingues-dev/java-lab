package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class TestaPerformance {

    public static void main(String[] args) {
        Collection<Integer> numArray = new ArrayList<>();
        Long tempoDeExecucaoArray = TestaTempoColecaoDeNumeros(numArray);
        System.out.println();
        System.out.println("Tempo total Array = " + tempoDeExecucaoArray);

        Collection<Integer> numHashSet = new HashSet<>();
        Long tempoDeExecucaoHashSet = TestaTempoColecaoDeNumeros(numHashSet);
        System.out.println();
        System.out.println("Tempo total HashSet = " + tempoDeExecucaoHashSet);

        System.out.println();
        System.out.println("No caso do ArrayList, a inserção é bem rápida e a busca muito lenta!");
        System.out.println();
        System.out.println("No caso do HashSet, a inserção ainda é rápida, embora um pouco mais lenta do que a das listas. Mas a busca é muito rápida!");
        System.out.println("Listas não são rápidas para pesquisas com mais de 50 mil registros");
        System.out.println();

    }

    public static Long TestaTempoColecaoDeNumeros(Collection<Integer> numeros) {
        Long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }

        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        Long fim = System.currentTimeMillis();
        Long tempoDeExecucao = fim - inicio;
        return tempoDeExecucao;
    }

}