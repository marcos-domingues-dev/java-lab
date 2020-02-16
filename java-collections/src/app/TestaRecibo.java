package app;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TestaRecibo {

    public static void main(String[] args) {
        Recibo r1 = new Recibo("1");
        Recibo r2 = new Recibo("2");
        Recibo r3 = new Recibo("3");

        
        // Para adicionarmos um objeto em um TreeSet ele precisa implementar a interface
        // Comparable.
        // Ou, no construtor do TreeSet recebe como parâmetro um objeto que implementa
        // Comparator.
        
        Comparator<Recibo> sortRecibo = (Recibo a, Recibo b) -> (a.getNumero().compareTo(b.getNumero()));
        Set<Recibo> recibos = new TreeSet<>(sortRecibo);
        recibos.add(r1);
        recibos.add(r2);
        recibos.add(r3);

        System.out.println();
        System.out.println("Recibos=" + recibos);
    }

}