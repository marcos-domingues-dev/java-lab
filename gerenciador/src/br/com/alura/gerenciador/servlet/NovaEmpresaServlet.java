package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		// Get parameters
		String paramNomeEmpresa = request.getParameter("nome");
		
		// Model / Domain
		Integer idEmpresa = Banco.getEmpresaNextId();
		Empresa empresa = new Empresa(idEmpresa, paramNomeEmpresa);
		Banco banco = new Banco();
		banco.adicionar(empresa);
		
		// Chamar o JPS / Response
		RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		request.setAttribute("nomeEmpresa", empresa.getNome());
		rd.forward(request, response);
	}
	
	// -- Suporta GET e POST
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String nomeEmpresa = request.getParameter("nome");		
		PrintWriter out = response.getWriter();
		out.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</html></body>");
		System.out.println("Service acionado para " + nomeEmpresa);
	}*/
	
}
