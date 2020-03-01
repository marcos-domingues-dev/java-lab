package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	
	private static List<Empresa> empresas = new ArrayList<>();
	
	static {
		Empresa e1 = new Empresa(1, "Alura");
		Empresa e2 = new Empresa(2, "Caelum");
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

}
