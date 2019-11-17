
public class folhaTester {

	public static void main(String[] args) {
		Funcionario d = new Designer();
		d.setNome("Dead Pool");
		d.setSalario(1000.0);

		Funcionario g = new Gerente();
		g.setNome("Aladin");
		g.setSalario(1000.0);
		
		ControlePagto c = new ControlePagto();
		c.adicionar(d);
		c.adicionar(g);
		c.imprimir();
	}
}
