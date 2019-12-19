package br.com.bytebank.bytebanksystem.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class IteratorTest {

	public static void main(String[] args) {

		// --------------------------------------------------------------------------------
		// Iteração com Listas
		List<String> nameList = new ArrayList<>();
		nameList.add("Super Mario");
		nameList.add("Yoshi");
		nameList.add("Donkey Kong");

		Iterator<String> it = nameList.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		// --------------------------------------------------------------------------------
		// Iteração com Conjuntos
		Set<String> nameSet = new HashSet<>();
		nameSet.add("Super Mario");
		nameSet.add("Yoshi");
		nameSet.add("Donkey Kong");

		Iterator<String> it2 = nameSet.iterator();

		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
	}
}
