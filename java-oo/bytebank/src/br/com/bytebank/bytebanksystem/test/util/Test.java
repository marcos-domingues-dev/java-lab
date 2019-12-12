package br.com.bytebank.bytebanksystem.test.util;

import java.util.ArrayList;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class Test {

	public static void main(String[] args) {

		ArrayList<Account> accounts = new ArrayList<Account>();

		Customer c1 = new Customer();
		c1.setName("Robert C. \"Uncle Bob\" Martin");
		Account a1 = new CheckingAccount(100, 221, c1);
		accounts.add(a1);

		Customer c2 = new Customer();
		c2.setName("Martin Fowler");
		Account a2 = new CheckingAccount(100, 221, c2);
		accounts.add(a2);

		Customer c3 = new Customer();
		c3.setName("Erich Gamma");
		Account a3 = new CheckingAccount(100, 221, c3);
		accounts.add(a3);

		for (Account a : accounts) {
			System.out.println(a);
		}
		
		if (accounts.contains(a3)) {
			System.out.println(a3.getCustomer().getName() + " account was matched!");
		}		
	}
}
