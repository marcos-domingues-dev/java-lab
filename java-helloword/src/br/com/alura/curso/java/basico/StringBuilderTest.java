package br.com.alura.curso.java.basico;

public class StringBuilderTest {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Aloha! ");
		sb.append("I'm in the Caribbean, ");
		sb.append("and I don't want to go back!");

		System.out.println(sb.toString());
		
		String myVacation = "My Vacation diary: <text>";
		System.out.println(myVacation.replace("<text>", sb));

		// StringBuilder implements "CharSequence"
        // String too implements "CharSequence"		
	}
}
