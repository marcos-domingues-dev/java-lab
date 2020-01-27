package coupling.test;

import java.util.ArrayList;
import java.util.List;

import coupling.model.AcaoAposGerarNf;
import coupling.model.EnviadorDeEmail;
import coupling.model.Fatura;
import coupling.model.GeradorDeNotaFiscal;
import coupling.model.NotaFiscal;
import coupling.model.NotaFiscalDao;

public class TestaGeradorDeNotaFiscal {

	
	public static void main(String[] args) {
		EnviadorDeEmail mail = new EnviadorDeEmail();
		NotaFiscalDao nfDao = new NotaFiscalDao();
		
		List<AcaoAposGerarNf> acoesAposGerarNf = new ArrayList<AcaoAposGerarNf>();
		acoesAposGerarNf.add(mail);
		acoesAposGerarNf.add(nfDao);
		
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoesAposGerarNf);
		
		Fatura fatura = new Fatura(200, "Martin Fowler");	
		NotaFiscal nf = gerador.gera(fatura);
		
		System.out.println("Valor bruto: " + nf.getValorBruto());
		System.out.println("Valor impostos: " + nf.getImpostos());
		System.out.println("Valor líquido: " + nf.getValorLiquido());
	}
}
