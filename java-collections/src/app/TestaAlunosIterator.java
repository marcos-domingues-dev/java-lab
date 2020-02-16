package app;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestaAlunosIterator {

    public static void main(String[] args) {
        Set<Aluno> alunos = new HashSet<>();
        alunos.add(new Aluno("José", 101));
        alunos.add(new Aluno("Maria", 101));
        alunos.add(new Aluno("Manuel", 101));

        System.out.println();
        Iterator<Aluno> iterador = alunos.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }
}