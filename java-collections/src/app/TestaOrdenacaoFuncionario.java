package app;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TestaOrdenacaoFuncionario {

    public static void main(String[] args) {
        Funcionario f2 = new Funcionario("Tiago", 36);
        Funcionario f3 = new Funcionario("Joao", 28);
        Funcionario f1 = new Funcionario("Pedro", 49);

        FuncionarioOrdemDe ordem = new FuncionarioOrdemDe();
        Set<Funcionario> funcionarios = new TreeSet<>(ordem);
        funcionarios.add(f1);
        funcionarios.add(f2);
        funcionarios.add(f3);

        System.out.println();
        // System.out.println(funcionarios);

        Iterator<Funcionario> iterador = funcionarios.iterator();

        while (iterador.hasNext()) {
            System.out.println(iterador.next().getNome());
        }

    }

}