package builder.test;

import builder.model.ItemDaNota;
import builder.model.NotaFiscal;
import builder.model.NotaFiscalBuilder;

public class TesteNFBuilder {
    
	public static void main(String[] args) {
        NotaFiscalBuilder nfBuilder = new NotaFiscalBuilder();
        nfBuilder.paraEmpresa("Caelum");
        nfBuilder.comCnpj("123.456.789/0001-10");
        nfBuilder.comItem(new ItemDaNota("item 1", 100.0));
        nfBuilder.comItem(new ItemDaNota("item 2", 200.0));
        nfBuilder.comItem(new ItemDaNota("item 3", 300.0));
        nfBuilder.comObservacoes("entregar nf pessoalmente");
        nfBuilder.naDataAtual();

        NotaFiscal nf = nfBuilder.constroi();
        System.out.println(nf.getValorBruto());
    }
}
