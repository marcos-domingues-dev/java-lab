package app;

public class Aula implements Comparable<Aula> {

    private String titulo;
    private int tempo;

    public Aula(String titulo, int tempo) {
        this.titulo = titulo;
        this.tempo = tempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTempo() {
        return tempo;
    }

    @Override
    public String toString() {
        return "Aula [tempo=" + tempo + ", titulo=" + titulo + "]";
    }

    @Override
    public int compareTo(Aula other) {
        return this.titulo.compareTo(other.getTitulo());
    }

    
}