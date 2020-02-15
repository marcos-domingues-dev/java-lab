package app;

public class TestaComparacaoStrings {

    public static void main(String[] args) {

        String s1 = "paulo";
        String s2 = "silveira";
        int resultado = s1.compareTo(s2);

        /******************************************
        Esse método compareTo() devolve:
        - um número negativo se s1 é menor que s2
        - um número positivo se s2 é menor que s1
        - 0 se forem iguais.

        * Ordem lexicográfica (alfabética, por assim dizer)
        *******************************************/

        System.out.println();
        System.out.println(resultado);
    }
}