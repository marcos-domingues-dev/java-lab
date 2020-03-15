package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebida a requisição HTTP
		Banco banco = new Banco();
		List<Empresa> listaEmpresas = banco.getEmpresas();
		
		// O dispatcher direciona para uma página JSP.
		// Atribuindo parâmetros em "listaEmpresas", para que o JSP possa operar.
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		request.setAttribute("listaEmpresas", listaEmpresas);
		rd.forward(request, response);
	}
}