package test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TesteUnicodeEncoding {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		// Java usa unicode "por baixo dos panos" ...		
		String s = "C";		
		System.out.println(s.codePointAt(0)); //-> 67
		
		// CharSet define como traduzir 
		Charset defaultCharset = Charset.defaultCharset();
		System.out.println(defaultCharset.displayName()); //-> Eclipse/windows-1252  -- VSCode/UTF-8
		
		// Usando o default do windows
		byte[] bytes = s.getBytes();
		System.out.print(bytes.length + ", windows-1252 -- ");
		String sNovo = new String(bytes, "windows-1252");
		System.out.println(sNovo);
		
		// Usando o default do windows
		byte[] b1 = s.getBytes("UTF-8");
		System.out.print(b1.length + ", UTF-8 -- ");
		String sNovo2 = new String(b1, "UTF-8");
		System.out.println(sNovo2);

		// Usando UTF-16
		byte[] b2 = s.getBytes("UTF-16");
		System.out.print(b2.length + ", UTF-16 -- ");
		String sNovo3 = new String(b2, "UTF-16");
		System.out.println(sNovo3);

		// Usando StandardCharsets.US_ASCII
		byte[] b3 = s.getBytes(StandardCharsets.US_ASCII);
		System.out.print(b3.length + ", US_ASCII -- ");
		String sNovo4 = new String(b3, StandardCharsets.US_ASCII);
		System.out.println(sNovo4);
		
		
	}
}
