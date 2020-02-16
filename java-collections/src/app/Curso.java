package app;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Curso {

    private String nome;
    private String instrutor;
    private List<Aula> aulas = new LinkedList<Aula>();
    private Set<Aluno> alunos = new HashSet<>();
    private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();

    public Curso(String nome, String instrutor) {
        // Boa prática!
        // String nome é um objeto - pode ser null
        if (nome == null) {
            throw new NullPointerException("Nome do curso não pode ser null.");
        }
        if (instrutor == null) {
            throw new NullPointerException("Nome do instrutor não pode ser null.");
        }

        this.nome = nome;
        this.instrutor = instrutor;
    }

    // Encapsulamos o acesso às matrículas do curso
    public Set<Aluno> getAlunos() {
        return Collections.unmodifiableSet(alunos);
    }

    public void matricula(Aluno aluno) {
        this.alunos.add(aluno);

        // Apenas o último aluno adicionado é apresentado na chave é mantido.
        this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
    }

    public boolean estaMatriculado(Aluno aluno) {
        // Olhando a documentação da interface Collection e indo no método contains,
        // veremos que ele utiliza o método equals - do Aluno.
        // o contains utilizará a estrutura bem implementada da tabela de espalhamento,
        // e irá retornar rapidamente true ou false

        return this.alunos.contains(aluno);
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
        return "Curso [nome: " + this.nome + ", instrutor: " + this.instrutor + ", aulas: " + this.aulas + ", alunos: "
                + this.alunos + "]";
    }

    public Aluno buscaMatriculado(int matricula) {
        // Com Map<> se pesquisa pela "chave" !
        // pois o algoritmo implementado dentro de HashMap é bastante otimizado para
        // velocidade (usa o mesmo princípio da tabela de espalhamento)
        return this.matriculaParaAluno.get(matricula);
    }

}