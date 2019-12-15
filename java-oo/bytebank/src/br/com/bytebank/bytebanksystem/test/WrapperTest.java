package br.com.bytebank.bytebanksystem.test;

import java.util.ArrayList;
import java.util.List;

public class WrapperTest {

	public static void main(String[] args) {
		Integer ref = Integer.valueOf("3");
		ref++;
		System.out.println(ref);

		Integer idadeRef = Integer.valueOf(29); // autoboxing
		System.out.println(idadeRef.intValue()); // unboxing

		Double dRef = Double.valueOf(3.2);// autoboxing
		System.out.println(dRef.doubleValue());// unboxing

		Boolean bRef = Boolean.FALSE;
		System.out.println(bRef.booleanValue());

		// -- Base cass: Number
		Number refNumero = Integer.valueOf(29);  // -> Integer to Number
		
		// -- List of Number
		List<Number> lista = new ArrayList<>();
        lista.add(10);
        lista.add(32.6);
        lista.add(25.6f);
        
        for (Number n: lista) {
        	System.out.println("Number=" + n);
        }

	}
}