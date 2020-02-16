package app;

import java.util.Collections;
import java.util.Set;

public class TesteEmptySet {

    public static void main(String[] args) {
        Set<String> nomes = Collections.emptySet();
        
        // Exception -> java.lang.UnsupportedOperationException
        // nomes.add("Paulo"); // o que acontece aqui?

        // Qual a utilidade de um emptySet ?
        // imagina que você precisa representar um curso que foi cancelado pois não teve
        // matriculas.
    }

}