
public class Gerente extends Funcionario {

	public double getBonificacao() {
		return super.getSalario() * 0.2;
	}
}
