package coupling.model;

import java.util.List;

public class GeradorDeNotaFiscal {
    private final List<AcaoAposGerarNf> acoesAposGerarNf;

    public GeradorDeNotaFiscal(List<AcaoAposGerarNf> acoesAposGerarNf) {
        this.acoesAposGerarNf = acoesAposGerarNf;
    }

    public NotaFiscal gera(Fatura fatura) {

        double valor = fatura.getValorMensal();

        NotaFiscal nf = new NotaFiscal(valor, impostoSimplesSobre(valor));

        for (AcaoAposGerarNf acao : acoesAposGerarNf) {
        	acao.executar(nf);
        }

        return nf;
    }

    private double impostoSimplesSobre(double valor) {
        return valor * 0.06;
    }
}
