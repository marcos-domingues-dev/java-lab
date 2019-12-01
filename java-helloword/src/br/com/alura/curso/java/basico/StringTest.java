package br.com.alura.curso.java.basico;

public class StringTest {

	public static void main(String[] args) {
		String nome = "James Bond";
		
		// Single quotes for "char" type.
		System.out.println(nome.replace('B', 'K'));
		System.out.println(nome.replace("Bond", "Norrington"));

		// Upper and Lower
		System.out.println(nome.toUpperCase());
		System.out.println(nome.toLowerCase());
		
		// charAt, indexOf, subString
		System.out.println(nome.charAt(2));
		System.out.println(nome.indexOf('B'));
		System.out.println(nome.substring(6));
		
		// length
		System.out.println(nome.length());
		System.out.println(nome.isEmpty());
		System.out.println(nome.contains("Bo"));
		
	}
}
