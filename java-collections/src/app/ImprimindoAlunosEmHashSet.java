package app;

import java.util.HashSet;
import java.util.Set;

public class ImprimindoAlunosEmHashSet {

    public static void main(String[] args) {

        Set<String> alunos = new HashSet<>();
        alunos.add("Paulo");
        alunos.add("Alberto");
        alunos.add("Pedro");    
        alunos.add("Nico");    

       // Tente imprimir os alunos usando foreach
       // Aqui temos a prova de que o Set não mantém a ordem de inserção

       for (String aluno : alunos) {
           System.out.println(aluno);
       }

       // Um set não aceita duplicados !
       // Retorna false caso o item já esteja no conjunto:
       boolean adicionou = alunos.add("Pedro");
       System.out.println("Pedro foi adicionado ao Set? " + adicionou);
    }
}