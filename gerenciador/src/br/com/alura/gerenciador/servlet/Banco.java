package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();

	static {
		Date abertura = new Date();
		Empresa e1 = new Empresa(1, "Alura", abertura);
		Empresa e2 = new Empresa(2, "Caelum", abertura);
		Banco.empresas.add(e1);
		Banco.empresas.add(e2);
	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public static Integer getEmpresaNextId() {
		return Banco.empresas.size() + 1;
	}

	public void adicionar(Empresa empresa) {
		Banco.empresas.add(empresa);
	}

	public void removerEmpresa(Integer id) {
		Iterator<Empresa> it = Banco.empresas.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscarEmpresa(Integer id) {
		for (Empresa empresa : empresas) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public void alterarEmpresa(Empresa empresa) {
		int indice = 0;
		Iterator<Empresa> it = Banco.empresas.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == empresa.getId()) {
				Banco.empresas.set(indice, empresa);
			}
			indice++;
		}
	}

}
