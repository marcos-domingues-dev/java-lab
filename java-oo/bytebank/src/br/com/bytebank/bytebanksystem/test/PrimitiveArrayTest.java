package br.com.bytebank.bytebanksystem.test;

public class PrimitiveArrayTest {
	
	public static void main(String[] args) {
		
		int[] ages = new int[5];
		
		ages[0] = 19;
		ages[1] = 29;
		//ages[2] = ??; //--> Default value = 0 (zero, to integers)
		ages[3] = 49;
		ages[4] = 59;
		
		for (int i = 0; i < ages.length; i++) {
			System.out.println(ages[i]);
		}
		
		int[] literalRefs = {1,22,30,44,77};
		
		
		for (int i = 0; i < literalRefs.length; i++) {
			System.out.println(literalRefs[i]);
		}
		
	}

}
