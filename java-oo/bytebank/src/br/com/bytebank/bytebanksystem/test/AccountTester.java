package br.com.bytebank.bytebanksystem.test;

import br.com.bytebank.bytebanksystem.model.Account;
import br.com.bytebank.bytebanksystem.model.CheckingAccount;
import br.com.bytebank.bytebanksystem.model.Customer;
import br.com.bytebank.bytebanksystem.model.InsufficientFundsException;
import br.com.bytebank.bytebanksystem.model.SavingsAccount;

public class AccountTester {

	public static void main(String[] args) {

		Customer vipCustomer = new Customer();
		vipCustomer.setName("Capitão América");
		Account vpSavingsAccount = new SavingsAccount(100, 333, vipCustomer);
		Account vpCheckingAccount = new CheckingAccount(100, 444, vipCustomer);
		vpSavingsAccount.deposit(400);
		vpCheckingAccount.deposit(1000);
		try {
			vpCheckingAccount.transfers(50, vpSavingsAccount);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}

		Customer newHeroe = new Customer();
		newHeroe.setName("Gost Hider");
		Account hSavingsAccount = new SavingsAccount(888, 741, newHeroe);
		Account hCheckingAccount = new CheckingAccount(888, 742, newHeroe);
		hSavingsAccount.deposit(8000);
		hCheckingAccount.deposit(9000);
		try {
			hCheckingAccount.transfers(30000, hSavingsAccount);
		} catch (InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Vip Savings: " + vpSavingsAccount.getBalance());
		System.out.println("Vip Checking: " + vpCheckingAccount.getBalance());
		System.out.println("Heroe Savings: " + hSavingsAccount.getBalance());
		System.out.println("Heroe Checking: " + hCheckingAccount.getBalance());

	}
}
