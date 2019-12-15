package br.com.bytebank.bytebanksystem.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.AccountComparator;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class SortTest {

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

		for (Account a : items) {
			System.out.println(a.toString());
		}

		// items.sort(new AccountComparator());
		Collections.sort(items, new AccountComparator());
		
		System.out.println("----------");
		
		
		for (Account a : items) {
			System.out.println(a.toString());
		}

	}
}