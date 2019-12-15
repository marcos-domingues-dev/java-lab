package br.com.bytebank.bytebanksystem.test;

import java.util.Arrays;

public class ArraySortTest {

	public static void main(String[] args) {

		int[] numbers = new int[] {3, 7, 1, 9, 5};
		
		Arrays.sort(numbers);
		
		System.out.println(Arrays.toString(numbers));
	}

}
