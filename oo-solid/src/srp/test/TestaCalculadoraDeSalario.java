package srp.test;

import srp.model.CalculadoraDeSalario;
import srp.model.Cargo;
import srp.model.Funcionario;

public class TestaCalculadoraDeSalario {

	public static void main(String[] args) {
		CalculadoraDeSalario c = new CalculadoraDeSalario();
		
		Funcionario funcionarioA = new Funcionario();
		funcionarioA.setCargo(Cargo.DESENVOLVEDOR);
		funcionarioA.setSalarioBase(3000);

		Funcionario funcionarioB = new Funcionario();
		funcionarioB.setCargo(Cargo.DBA);
		funcionarioB.setSalarioBase(4000);
		
		System.out.println("Salario A " + c.calcula(funcionarioA));
		System.out.println("Salario B " + c.calcula(funcionarioB));
	}
}
