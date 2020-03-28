package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AcaoAlterarEmpresa;
import br.com.alura.gerenciador.acao.AcaoListarEmpresas;
import br.com.alura.gerenciador.acao.AcaoMostrarEmpresa;
import br.com.alura.gerenciador.acao.AcaoNovaEmpresa;
import br.com.alura.gerenciador.acao.AcaoRemoverEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		if (paramAcao.equals("ListarEmpresas")) {
			AcaoListarEmpresas acao = new AcaoListarEmpresas();
			acao.executar(request, response);
		}  else if(paramAcao.equals("RemoverEmpresa")) {
		    AcaoRemoverEmpresa acao = new AcaoRemoverEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("MostrarEmpresa")) {
		    AcaoMostrarEmpresa acao = new AcaoMostrarEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("AlterarEmpresa")) {
		    AcaoAlterarEmpresa acao = new AcaoAlterarEmpresa();
		    acao.executa(request, response);
		} else if(paramAcao.equals("NovaEmpresa")) {
		    AcaoNovaEmpresa acao = new AcaoNovaEmpresa();
		    acao.executa(request, response);
		}
	}
}
