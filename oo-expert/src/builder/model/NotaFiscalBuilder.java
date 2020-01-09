package builder.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import observer.model.AcaoAposCriarNf;

public class NotaFiscalBuilder {
	private String razaoSocial;
	private String cnpj;
	private double impostos;
	private List<ItemDaNota> todosItens = new ArrayList<ItemDaNota>();
	private double valorBruto;
	private Calendar data;
	private String observacoes;
	private List<AcaoAposCriarNf> observadoresAposCriarNf;

	public NotaFiscalBuilder(List<AcaoAposCriarNf> observadoresAposCriarNf) {
		this.observadoresAposCriarNf = observadoresAposCriarNf;
	}

	public NotaFiscal constroi() {
		NotaFiscal nf = new NotaFiscal(razaoSocial, cnpj, data, valorBruto, impostos, todosItens, observacoes);

		for (AcaoAposCriarNf aposCriarNfObserver : observadoresAposCriarNf) {
			aposCriarNfObserver.executar(nf);
		}
		
		return nf;
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		
		return this;
	}

	public NotaFiscalBuilder comCnpj(String cnpj) {
		this.cnpj = cnpj;
		
		return this;
	}

	public NotaFiscalBuilder comItem(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		
		return this;
	}

	public NotaFiscalBuilder comObservacoes(String observacoes) {
		this.observacoes = observacoes;
		
		return this;
	}

	public NotaFiscalBuilder naDataAtual() {
		this.data = Calendar.getInstance();
		
		return this;
	}
}
