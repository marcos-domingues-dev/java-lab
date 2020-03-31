package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AcaoListarEmpresas implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Açao listar empresas!");
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		request.setAttribute("listaEmpresas", listaEmpresas);
		
		return "forward:listaEmpresas.jsp";
	}
}
