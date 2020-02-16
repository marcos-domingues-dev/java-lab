package app;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();
    private Set<Aluno> alunos = new HashSet<>();

    public Curso(String nome, String instrutor) {
        this.nome = nome;
        this.instrutor = instrutor;
    }

    // Encapsulamos o acesso às matrículas do curso
    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public void matricula(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    // Encapsulamos o acesso às aulas do curso
    public List<Aula> getAulas() {
        // Programação defensiva com unmodifiable
        return Collections.unmodifiableList(aulas);
    }

    public void adiciona(Aula aula) {
        this.aulas.add(aula);
    }

    public int getTempoTotal() {
        // No Java 8, toda coleção tem um método que
        // se chama stream, não iremos entrar em

        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "Curso [nome: " + this.nome + ", instrutor: " + this.instrutor + ", aulas: " + this.aulas + ", alunos: " + this.alunos + "]";
    }
    
}