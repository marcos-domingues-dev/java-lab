package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AcaoListarEmpresas {

	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Açao listar empresas!");
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();

		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		request.setAttribute("listaEmpresas", listaEmpresas);
		rd.forward(request, response);
	}
}
