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

public class AcaoNovaEmpresa implements Acao {

	public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNomeEmpresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("data");

		Date dataAbertura = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Integer idEmpresa = Banco.getEmpresaNextId();
		Empresa empresa = new Empresa(idEmpresa, paramNomeEmpresa, dataAbertura);
		Banco banco = new Banco();
		banco.adicionar(empresa);

		request.setAttribute("nomeEmpresa", empresa.getNome());
		return "redirect:entrada?acao=ListarEmpresas"; 
	}
}
