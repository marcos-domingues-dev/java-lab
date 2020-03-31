package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AcaoAlterarEmpresa implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);		
		String paramNomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");

		Date dataAbertura = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(id, paramNomeEmpresa, dataAbertura);
		
		Banco banco = new Banco();
		banco.alterarEmpresa(empresa);
		
		return "redirect:entrada?acao=ListarEmpresas";
	}
}
