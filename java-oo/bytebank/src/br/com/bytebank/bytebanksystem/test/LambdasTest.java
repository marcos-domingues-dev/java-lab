package br.com.bytebank.bytebanksystem.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.AccountComparator;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class LambdasTest {

	public static void main(String[] args) {

		List<Account> items = new ArrayList<Account>();

		Customer customer0 = new Customer();
		customer0.setName("Steve Rogers");
		Account ca0 = new CheckingAccount(001, 150, customer0);
		items.add(ca0);

		Customer customer1 = new Customer();
		customer1.setName("Tony Stark");
		Account ca1 = new CheckingAccount(001, 440, customer1);
		items.add(ca1);

		Customer customer2 = new Customer();
		customer2.setName("Bruce Bener");
		Account ca2 = new CheckingAccount(001, 720, customer2);
		items.add(ca2);

		Customer customer3 = new Customer();
		customer3.setName("Peter Parker");
		Account ca3 = new CheckingAccount(001, 610, customer3);
		items.add(ca3);

		Customer customer4 = new Customer();
		customer4.setName("Nicholas Joseph Fury");
		Account ca4 = new CheckingAccount(001, 310, customer4);
		items.add(ca4);

		// --------------------------------------------------------------------------------
		// Not sorted
		System.out.println("----------");
		System.out.println("Not sorted");
		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Natural sort
		System.out.println("----------");
		System.out.println("Natural sort - using interface 'java.lang.Comparable'");
		Collections.sort(items); // --> Using an method @Override in Account.compareTo().

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Sort list
		System.out.println("----------");
		System.out.println("Sort list with class comparator that implements 'java.util.Comparator'.");
		items.sort(new AccountComparator()); // --> Using an class to sort items.
		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Sort list - anonymous class
		System.out.println("----------");
		System.out.println("Sort list with anonymous class.");
		items.sort(new Comparator<Account>() {
			@Override
			public int compare(Account al, Account ar) {
				return Integer.compare(al.getNumber(), ar.getNumber());
			}
		});
		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Assign an anonymous variable to sort
		System.out.println("----------");
		System.out.println("Sort list with an anonymous sorting variable.");

		Comparator<Account> comp = new Comparator<Account>() {
			@Override
			public int compare(Account al, Account ar) {
				return Integer.compare(al.getNumber(), ar.getNumber());
			}
		};

		items.sort(comp);

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------		
		// --------------------------------------------------------------------------------
		// Lambdas: Sorting using lambdas
		System.out.println("----------");
		System.out.println("Sort with lambdas.");

		items.sort((Account al, Account ar) -> {
			return Integer.compare(al.getNumber(), ar.getNumber());
		});

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Lambdas: Sorting an anonymous variable using lambdas
		System.out.println("----------");
		System.out.println("Sort list with an anonymous sorting variable using lambdas.");

		Comparator<Account> comp2 = (Account al, Account ar) -> {
			return Integer.compare(al.getNumber(), ar.getNumber());
		};

		items.sort(comp2);

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Lambdas: Sorting using abbreviate lambdas
		System.out.println("----------");
		System.out.println("Sort with abbreviate lambdas.");

		items.sort((Account al, Account ar) -> Integer.compare(al.getNumber(), ar.getNumber()));

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Lambdas: Sorting an anonymous variable using abbreviate lambdas
		System.out.println("----------");
		System.out.println("Sort list with an anonymous sorting variable - using abbreviate lambdas.");

		Comparator<Account> comp3 = (Account al, Account ar) -> Integer.compare(al.getNumber(), ar.getNumber());

		items.sort(comp3);

		for (Account a : items) {
			System.out.println(a.toString());
		}		
		
		// --------------------------------------------------------------------------------
		// Lambdas: Sorting using abbreviate lambdas
		System.out.println("----------");
		System.out.println("Sort with abbreviate lambdas - whitout define class type.");

		items.sort((al, ar) -> Integer.compare(al.getNumber(), ar.getNumber()));

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// Lambdas: Sorting an anonymous variable using abbreviate lambdas
		System.out.println("----------");
		System.out.println("Sort list with an anonymous sorting variable - using abbreviate lambdas - whitout define class type.");

		Comparator<Account> comp4 = (al, ar) -> Integer.compare(al.getNumber(), ar.getNumber());

		items.sort(comp4);

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// --------------------------------------------------------------------------------
		// --------------------------------------------------------------------------------
		// Lambdas:
		System.out.println("----------");
		System.out.println("Lambdas...");

		
		items.forEach(new Consumer<Account>() {

			@Override
			public void accept(Account a) {
				System.out.println(a.toString());				
			}
			
		});
		
		// --------------------------------------------------------------------------------
		// Lambdas:
		System.out.println("----------");
		System.out.println("Lambdas...");

		items.forEach((a) -> System.out.println(a.toString()));		
	}
}