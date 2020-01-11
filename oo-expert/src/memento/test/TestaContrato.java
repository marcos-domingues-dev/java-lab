package memento.test;

import java.util.Calendar;

import memento.model.Contrato;
import memento.model.EstadoContrato;
import memento.model.HistoricoContrato;
import memento.model.TipoContrato;

public class TestaContrato {
	public static void main(String[] args) {
		HistoricoContrato historico = new HistoricoContrato();

		Contrato contrato = new Contrato("Netflix", Calendar.getInstance(), TipoContrato.NOVO);
		System.out.println(contrato.toString());

		historico.adicionar(contrato.gerarEstadoAtual());
		contrato.Avancar();
		System.out.println(contrato.toString());
		
		historico.adicionar(contrato.gerarEstadoAtual());
		contrato.Avancar();
		System.out.println(contrato.toString());
		
		historico.adicionar(contrato.gerarEstadoAtual());
		contrato.Avancar();		
		System.out.println(contrato.toString());
		
		
		System.out.println();
		System.out.println("Recuperando estados:");
		EstadoContrato estadoInicial = historico.buscar(0);
		System.out.println("Inicial: " + estadoInicial.getContrato().toString());
		
		EstadoContrato estadoAnterior = historico.buscar(2);
		System.out.println("Anterior: " + estadoAnterior.getContrato().toString());
		
	}
}
