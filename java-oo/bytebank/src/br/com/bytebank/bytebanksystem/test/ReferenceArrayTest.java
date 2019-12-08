package br.com.bytebank.bytebanksystem.test;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class ReferenceArrayTest {
	
	public static void main(String[] args) {
		
		Account[] accounts = new Account[5];
		
		Customer customer0 = new Customer();
		customer0.setName("Steve Rogers");
		accounts[0] = new CheckingAccount(001, 150, customer0);
		
		Customer customer1 = new Customer();
		customer1.setName("Tony Stark");
		accounts[1] = new CheckingAccount(001, 440, customer1);
		
		Customer customer2 = new Customer();
		customer2.setName("Bruce Bener");
		accounts[2] = new CheckingAccount(001, 720, customer2);
		
		Customer customer3 = new Customer();
		customer3.setName("Peter Parker");
		accounts[3] = new CheckingAccount(001, 610, customer3);
		
		Customer customer4 = new Customer();
		customer4.setName("Nicholas Joseph Fury");
		accounts[4] = new CheckingAccount(001, 310, customer4);
		
		
		for (int i = 0; i < accounts.length; i++) {
			Account a = accounts[i];
			System.out.println(a.getCustomer().getName());
		}
		
	}

}
