package chainOfResponsibility.model;

public class FabricaDaCorrenteDeDesconto {

	public static Desconto DescontosPadrao() {
		Desconto descontoPorMaisDeCincoItens = new DescontoPorMaisDeCincoItens();
		Desconto descontoPorMaisDeQuinhentos = new DescontoPorMaisDeQuinhentosReais();
		Desconto descontoPorVendaCasada = new DescontoPorVendaCasada();
		Desconto descontoZerado = new DescontoZerado();
		
		descontoPorMaisDeCincoItens.setProximo(descontoPorMaisDeQuinhentos);
		descontoPorMaisDeQuinhentos.setProximo(descontoPorVendaCasada);
		descontoPorVendaCasada.setProximo(descontoZerado);

		return descontoPorMaisDeCincoItens;
	}
}
