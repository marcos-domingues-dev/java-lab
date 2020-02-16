package app;

import java.util.List;

public class TestaCurso {

    public static void main(String[] args) {
        System.out.println();

        Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

        javaColecoes.adiciona(new Aula("Trabalhando com ArrayList", 21));
        javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
        javaColecoes.adiciona(new Aula("Modelando com coleções", 24));
        
        List<Aula> aulas = javaColecoes.getAulas();
        System.out.println(aulas);

    }
}