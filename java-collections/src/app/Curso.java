package app;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();

    /*
     * O ArrayList, como diz o nome, internamente usa um array para guardar os
     * elementos. Ele consegue fazer operações de maneira muito eficiente, como
     * invocar o método get(indice). Se você precisa pegar o décimo quinto elemento,
     * ele te devolverá isso bem rápido.
     * 
     */

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public List<Aula> getAulas() {
        // Programação defensiva com unmodifiable
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }

}