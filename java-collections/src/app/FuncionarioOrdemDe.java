package app;

import java.util.Comparator;

public class FuncionarioOrdemDe implements Comparator<Funcionario> {

    @Override
    public int compare(Funcionario f1, Funcionario f2) {
        return f2.getIdade() - f1.getIdade();
    }

}