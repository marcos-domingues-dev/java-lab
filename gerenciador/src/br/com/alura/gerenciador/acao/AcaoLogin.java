package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class AcaoLogin implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");

		System.out.println("Logando " + paramLogin);

		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(paramLogin, paramSenha);

		if (usuario != null) {
			return "redirect:entrada?acao=ListarEmpresas";
		} else {
			return "redirect:entrada?acao=ShowFormLogin";
		}
			
	}

}
