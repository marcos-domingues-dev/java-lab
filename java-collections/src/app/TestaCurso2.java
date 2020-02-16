package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

    public static void main(String[] args) {
        Curso javaColecoes = new Curso("Dominando as colecoes do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com colecoes", 24));

        List<Aula> aulasImutaveis = javaColecoes.getAulas();
        System.out.println();
        System.out.println(aulasImutaveis);

        List<Aula> aulas = new ArrayList<>(aulasImutaveis);
        Collections.sort(aulas);
        System.out.println();
        System.out.println(aulas);

        System.out.println();
        System.out.println(javaColecoes);


        // Collections.reverse() - inverter a ordem
        // Collections.shuffle() - embaralhar
        // Collections.singletonList() - lista imutavel com unico elemento

        // Collections.nCopies() - lista imutavel com N de um elemento
        // + Este método também é utilizado para inicializar Listas
        //  recém criadas com Null
        // List<Type> list = new ArrayList<Type>(Collections.nCopies(1000, (Type)null));
    }
}