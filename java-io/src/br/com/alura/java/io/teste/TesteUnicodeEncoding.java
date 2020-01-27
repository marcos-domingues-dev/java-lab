package br.com.alura.java.io.teste;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEncoding {
	
	public static void main(final String[] args) throws UnsupportedEncodingException {
		// Java usa unicode "por baixo dos panos" ...		
		final String s = "C";		
		System.out.println(s.codePointAt(0)); //-> 67
		
		// CharSet define como traduzir 
		final Charset defaultCharset = Charset.defaultCharset();
		System.out.println(defaultCharset.displayName()); //-> windows-1252
		
		// Usando o default do windows
		final byte[] bytes = s.getBytes();
		System.out.println(bytes.length + ", windows-1252");
		final String sNovo = new String(bytes, "windows-1252");
		System.out.println(sNovo);
		
		// Usando o default do windows
		final byte[] b1 = s.getBytes("windows-1252");
		System.out.println(b1.length + ", windows-1252");

		// Usando UTF-16
		final byte[] b2 = s.getBytes("UTF-16");
		System.out.println(b2.length + ", UTF-16");

		// Usando StandardCharsets.US_ASCII
		final byte[] b3 = s.getBytes(StandardCharsets.US_ASCII);
		System.out.println(b3.length + ", US_ASCII");
		
		
		
	}
}
