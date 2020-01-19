package coupling.test;

import coupling.model.EnviadorDeEmail;
import coupling.model.Fatura;
import coupling.model.GeradorDeNotaFiscal;
import coupling.model.NotaFiscal;
import coupling.model.NotaFiscalDao;

public class TestaGeradorDeNotaFiscal {

	
	public static void main(String[] args) {
		EnviadorDeEmail mail = new EnviadorDeEmail();
		NotaFiscalDao nfdao = new NotaFiscalDao();
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(mail, nfdao);
		
		Fatura fatura = new Fatura();
		fatura.setCliente("Martin Fowler");
		fatura.setValorMensal(200);
		
		NotaFiscal nf = gerador.gera(fatura);
		
		System.out.println("Valor bruto: " + nf.getValorBruto());
		System.out.println("Valor impostos: " + nf.getImpostos());
		System.out.println("Valor líquido: " + nf.getValorLiquido());
	}
}
