package app;

import java.util.HashMap;
import java.util.Map;

public class TesteExercicioMap {
    public static void main(String[] args) {
        Map<Integer, String> pessoas = new HashMap<>();

        pessoas.put(21, "Leonardo Cordeiro");
        pessoas.put(27, "Fabio Pimentel");
        pessoas.put(19, "Silvio Mattos");
        pessoas.put(23, "Romulo Henrique");


        // Iterando Maps
        // Acessando as chaves, depois o valor
        pessoas.keySet().forEach(idade -> {
            System.out.println(pessoas.get(idade));
        });
    }

}