package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AcaoNovaEmpresaForm implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "forward:formNovaEmpresa.jsp";
	}

}