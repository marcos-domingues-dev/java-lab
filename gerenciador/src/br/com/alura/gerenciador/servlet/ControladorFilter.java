package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;

//@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;

		String paramAcao = request.getParameter("acao");
		String resposta = null;

		try {
			String nomeDaClasse = "br.com.alura.gerenciador.acao.Acao" + paramAcao;
			Class classeDeAcao = Class.forName(nomeDaClasse);
			Object obj = classeDeAcao.newInstance();
			Acao acao = (Acao) obj;
			
			resposta = acao.executar(request, response);
			
		} catch (ClassNotFoundException | ServletException | IOException | InstantiationException
				| IllegalAccessException e) {
			throw new ServletException(e);
		}

		String[] respostaArgs = resposta.split(":");
		if (respostaArgs[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + respostaArgs[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(respostaArgs[1]);
		}
		
		// chain.doFilter(request, response);
	}
}
