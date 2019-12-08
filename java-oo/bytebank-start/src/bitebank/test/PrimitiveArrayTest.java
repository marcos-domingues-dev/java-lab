package bitebank.test;

public class PrimitiveArrayTest {
	
	public static void main(String[] args) {
		
		int[] ages = new int[5];
		
		ages[0] = 19;
		ages[1] = 29;
		//ages[2] = 39;
		ages[3] = 49;
		ages[4] = 59;
		
		for (int i = 0; i < ages.length; i++) {
			System.out.println(ages[i]);
		}
	}

}
