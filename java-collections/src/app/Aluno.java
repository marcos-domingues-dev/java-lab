package app;

public class Aluno {
    private String nome;
    private int numeroMatricula;

    public Aluno(String nome, int numeroMatricula) {
        // Boa prática!
        // String nome é um objeto - pode ser null
        if (nome == null) {
            throw new NullPointerException("Nome do aluno não pode ser null.");
        }
        this.nome = nome;
        this.numeroMatricula = numeroMatricula;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    @Override
    public String toString() {
        return "Aluno [nome=" + nome + ", numeroMatricula=" + numeroMatricula + "]";
    }

    @Override
    public int hashCode() {

        // return this.nome.hashCode();

        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + numeroMatricula;
        return result;
    }

    // regra: caso você sobrescreva o método equals, obrigatoriamente deverá
    // sobrescrever o método hashCode.

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numeroMatricula != other.numeroMatricula)
            return false;
        return true;
    }

}