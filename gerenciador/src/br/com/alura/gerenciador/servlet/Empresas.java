package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class Empresas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// API (Application Programming Interface)
		// No contexto de Web Service, a API define a interface das funcionalidades que o serviço oferece
		
		// https://github.com/google/gson
		// https://github.com/google/gson/blob/master/UserGuide.md#TOC-Object-Examples

		String valor = request.getHeader("Accept");
		System.out.println(valor);

		List<Empresa> empresas = new Banco().getEmpresas();

		if (valor.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xmlEmpresas = xstream.toXML(empresas);

			response.setContentType("application/xml"); // -> MimeType
			response.getWriter().print(xmlEmpresas);
		} else if(valor.endsWith("json")) {

			Gson gson = new Gson();
			String jsonEmpresas = gson.toJson(empresas);

			response.setContentType("application/json"); // -> MimeType
			response.getWriter().print(jsonEmpresas);
		} else {
		    response.setContentType("application/json");
		    response.getWriter().print("{'message':'no content'}");
		}
	}

}
