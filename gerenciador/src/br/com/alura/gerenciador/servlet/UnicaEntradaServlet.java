package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
		boolean ehUmaAcaoProtegida = (!paramAcao.equals("Login")) && (!paramAcao.equals("ShowFormLogin"));

		if (usuarioNaoEstaLogado && ehUmaAcaoProtegida) {
			response.sendRedirect("entrada?acao=ShowFormLogin");	
			return;
		}
		
		String resposta = null;
		
		try {
			String nomeDaClasse = "br.com.alura.gerenciador.acao.Acao" + paramAcao;		
			Class classeDeAcao = Class.forName(nomeDaClasse);
			Object obj = classeDeAcao.newInstance();
			Acao acao = (Acao) obj;
			resposta = acao.executar(request, response);
		} catch (ClassNotFoundException | ServletException | IOException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] respostaArgs = resposta.split(":");
		if (respostaArgs[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + respostaArgs[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(respostaArgs[1]);		
		}
	}
}
