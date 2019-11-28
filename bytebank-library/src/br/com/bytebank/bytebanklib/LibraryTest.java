package br.com.bytebank.bytebanklib;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;

public class LibraryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Customer c = new Customer();
		c.setName("José Bezerra");
		
		Account ca = new CheckingAccount(123, 111, c);
		ca.deposit(18000);
		ca.deposit(35000);
		
		System.out.println(ca.getBalance());		
		System.out.println(ca.getCustomer().getName());
	}
}
