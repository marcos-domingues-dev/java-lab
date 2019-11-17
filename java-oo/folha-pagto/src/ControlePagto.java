
public class ControlePagto {

	private double total;

	public void adicionar(Funcionario f) {
		this.total += f.getBonificacao();
	}
	
	public void imprimir() {
		System.out.println(total);
	}
}
