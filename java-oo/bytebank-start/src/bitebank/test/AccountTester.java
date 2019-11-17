package bitebank.test;

import bitebank.entities.Customer;
import bitebank.entities.Account;

public class AccountTester {
	
	public static void main(String[] args) {
	  Customer vipCustomer = new Customer();
	  vipCustomer.setName("Marcos Domingues");
	  vipCustomer.setCpf("333.444.555-66");
	  vipCustomer.setEndereco("Av. Soberano Rei, 137");
	 
	  Account vipAccount = new Account();
	  vipAccount.setCustomer(vipCustomer);
	  vipAccount.deposit(21000.00);
	  vipAccount.deposit(18000.00);
	  vipAccount.deposit(35000.00);
	  
	  Customer samCustomer = new Customer();
	  samCustomer.setName("Samuel Domingues");
	  
	  Account universityAccount = new Account();
	  universityAccount.setCustomer(samCustomer);
	  
	  vipAccount.transfers(2500, universityAccount);
	  
	  System.out.println(vipAccount.getCustomer().getName());
	  System.out.println(vipAccount.getBalance());
	  System.out.println();
	  System.out.println(universityAccount.getCustomer().getName());
	  System.out.println(universityAccount.getBalance());

	}
}
