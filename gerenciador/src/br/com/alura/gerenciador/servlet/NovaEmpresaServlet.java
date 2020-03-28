package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		String paramDataAbertura = request.getParameter("data");

		// https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
		Date dataAbertura = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			// Poderíamos tentar escrever essa exceção ParseException na parte superior do
			// código, na linha de throws, mas isso não é permitido, afinal o método doPost()
			// está sobrescrevendo a classe Servlet, e sua assinatura não pode ser modificada,
			// pois a herança não permite uma nova exceção.
			
			// Padrão "catch and rethrow"
			throw new ServletException(e);
		}

		// Model / Domain
		Integer idEmpresa = Banco.getEmpresaNextId();
		Empresa empresa = new Empresa(idEmpresa, paramNomeEmpresa, dataAbertura);
		Banco banco = new Banco();
		banco.adicionar(empresa);

		// Response
		
		// 1. NÃO Chamar o Dispacher > JPS
		//RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
		//request.setAttribute("nomeEmpresa", empresa.getNome());
		//rd.forward(request, response);

		request.setAttribute("nomeEmpresa", empresa.getNome());
		
		// 2. Fazer
		// 	"Redirecionamento Client Side" --> redirecionar pelo navegador
		response.sendRedirect("listaEmpresas"); 
		
	}

}
