package bitebank.entities;

public class Account {	
	private Customer ownerOfAccount;
	private double balance;
	
	public Customer getCustomer() {
		return ownerOfAccount;
	}
	
	public void setCustomer(Customer customer) {
		this.ownerOfAccount = customer;
	}
	
	public double getBalance() {
		return balance;
	}	

	public void deposit(double value) {
		this.balance += value;
	}
	
	public boolean withdraw(double value ) {
		if (this.balance >= value) {
			this.balance -= value;
			return true;
		} else {
			return false;
		}
	}

	public boolean transfers(double value, Account destiny) {
		if (this.withdraw(value)) {
			destiny.deposit(value);
			return true;
		} else {
			return false;
		}
			
	}

}
