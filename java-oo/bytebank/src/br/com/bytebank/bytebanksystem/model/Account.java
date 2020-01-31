package br.com.bytebank.bytebanksystem.model;

import java.io.Serializable;

/**
 * Abstract base class to an account.
 * 
 * @author m.domingues
 * @version 1.0
 *
 */
public abstract class Account implements Serializable, Comparable<Account> {
	private static final long serialVersionUID = 1L;
	private int agency;
	private int number;
	private transient Customer ownerOfAccount; //-> Impedindo de serializar o objeto ...
	private double balance = 0;

	/**
	 * Constructor with defaults params.
	 * 
	 * @param agency
	 * @param number
	 * @param owner
	 */
	public Account(int agency, int number, Customer owner) {
		this.agency = agency;
		this.number = number;
		this.ownerOfAccount = owner;
	}

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

	public boolean withdraw(double value) throws InsufficientFundsException {
		if (this.balance >= value) {
			this.balance -= value;
			return true;
		} else {
			throw new InsufficientFundsException("Insufficient funds; balance: " + this.balance);
		}
	}

	public boolean transfers(double value, Account destiny) throws InsufficientFundsException {
		if (this.withdraw(value)) {
			destiny.deposit(value);
			return true;
		} else {
			return false;
		}

	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return 
		  "agency=" + this.getAgency() + " " +
		  "number=" + this.getNumber() + " " +
		  "owner=" + this.getCustomer().toString() + " " +
		  "balance=" + balance;		
	}
	
	@Override
	public boolean equals(Object obj) {		
		Account another = (Account) obj;
		
		return (this.getAgency() == another.getAgency())
			& (this.getNumber() == another.getNumber());
	}

	
	@Override
	public int compareTo(Account another) {
		return Double.compare(this.getBalance(), another.getBalance());
	}
	
}
