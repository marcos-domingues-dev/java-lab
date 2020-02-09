package app;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoListas {
    public static void main(String[] args) throws Exception {

        String cursoOO = "Object-Oriented";
        String curso1 = "Design Patterns";
        String curso2 = "SOLID" ;
        String curso3 = "TDD";

        ArrayList<String> aulas = new ArrayList<String>();
        aulas.add(cursoOO);
        aulas.add(curso2);
        aulas.add(curso1);
        aulas.add(curso3);
        System.out.println(aulas);

        String aulaOO = aulas.get(0);
        System.out.println("Resgatando:" + aulaOO);

        System.out.println("Removendo: " + aulas.get(0));
        aulas.remove(0);
        System.out.println(aulas);

        aulas.forEach(aula -> {
            System.out.println(aula);
        });

        Collections.sort(aulas);
        System.out.println(aulas);

    }
}