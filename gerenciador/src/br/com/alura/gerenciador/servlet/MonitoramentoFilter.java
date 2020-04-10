package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAcao = request.getParameter("acao");
		
		long inicioAcao = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long fimAcao = System.currentTimeMillis();
		
		System.out.println("Tempo de execu��o - " + paramAcao + " :" + (fimAcao - inicioAcao));
	}

}
