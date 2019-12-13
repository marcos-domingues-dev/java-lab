package br.com.bytebank.bytebanksystem.test;

public class IntegerTest {

	public static void main(String[] args) {
		Integer idadeRef = Integer.valueOf(19);
		int idade = idadeRef.intValue();
		System.out.println(idade);

		// Integer numero = Integer.valueOf(args[0]);   // autoboxing -> Returns an Object	
		// Integer.MAX_VALUE
		// Integer.MIN_VALUE		

		// int numero = Integer.parseInt(args[0]);  // unboxing -> Returns a primitive
		
		IntegerTest t = new IntegerTest();
		int numero = t.tryParse(args[0], -1);
		System.out.println(numero);
		
		
		System.out.println("Integer.MAX_VALUE=" +Integer.MAX_VALUE); // 2^31 - 1
		System.out.println("Integer.MIN_VALUE=" + Integer.MIN_VALUE); //-2^31

		System.out.println("Integer.SIZE=" + Integer.SIZE); // 32 bits
		System.out.println("Integer.BYTES=" + Integer.BYTES); //4 Bytes		
	}	
	
	public int tryParse(String value, int defaultVal) {
	    try {
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        return defaultVal;
	    }
	}

	public int tryParse(String value) {
	    return tryParse(value, 0);
	}
}
