package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		// https://hc.apache.org/httpcomponents-client-4.5.x/quickstart.html

		Content conteudo = Request
				.Post("http://localhost:8080/gerenciador/empresas")
				.addHeader("Accept", "application/xml")
				.execute()
				.returnContent();

		System.out.println(conteudo);
	}
}
