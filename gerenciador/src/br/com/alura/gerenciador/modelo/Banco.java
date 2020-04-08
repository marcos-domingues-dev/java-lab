package br.com.alura.gerenciador.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();

	static {
		Date abertura = new Date();
		Date abertura2 = new Date();
		abertura2.setMonth(2);
		LocalDateTime now = LocalDateTime.now();
		Empresa e1 = new Empresa(1, "Alura", abertura);
		Empresa e2 = new Empresa(2, "Caelum", abertura2);
		Banco.empresas.add(e1);
		Banco.empresas.add(e2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("marcos");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("samuel");
		u2.setSenha("654321");				
		usuarios.add(u1);
		usuarios.add(u2);
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
	
	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}

}
