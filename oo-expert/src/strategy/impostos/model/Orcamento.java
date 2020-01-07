package strategy.impostos.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import state.model.EstadoDeUmOrcamento;
import state.model.EstadoOrcamentoEmAprovacao;

public class Orcamento {
	private double valor;
	private final List<Item> itens;
	private EstadoDeUmOrcamento estadoAtual;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<Item>();
		this.estadoAtual = new EstadoOrcamentoEmAprovacao();
	}

	public void setEstadoAtual(EstadoDeUmOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public void aprovar() {
		this.estadoAtual.aprovar(this);
	}

	public void reprovar() {
		this.estadoAtual.reprovar(this);
	}

	public void finalizar() {
		this.estadoAtual.finalizar(this);
	}

	public void aplicarDescontoExtra(double descontoExtra) {
		this.valor -= descontoExtra;
	}

	public void aplicarDesconto() {
		this.estadoAtual.aplicarDescontoExtra(this);
	}

	public double getValor() {
		return valor;
	}

	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	public void adicionarItem(Item item) {
		this.itens.add(item);

	}

	public boolean contemItemDeNome(String nomeDoItem) {
		for (Item item : itens) {
			if (item.getNome().equals(nomeDoItem))
				return true;
		}
		return false;
	}
}
