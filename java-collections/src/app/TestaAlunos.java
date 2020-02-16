package app;

public class TestaAlunos {

    public static void main(String[] args) {
        Curso curso = new Curso("Java Collections", "Paulo Silveira");

        Aluno a1 = new Aluno("Maurício Aniche", 1013);
        Aluno a2 = new Aluno("Nico Stepach", 1014);
        Aluno a3 = new Aluno("Guilherme Silveira", 1015);

        curso.matricula(a1);
        curso.matricula(a2);
        curso.matricula(a3);

        System.out.println();
        System.out.println(curso);


        System.out.println();

        // Iterando com expressões lambdas do Java 8:
        curso.getAlunos().forEach(aluno -> {
            System.out.println(aluno);
        });
    }
}