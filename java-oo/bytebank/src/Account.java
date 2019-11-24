public abstract class Account {
	private int agency;
	private int number;
	private Customer ownerOfAccount;
	private double balance = 0; 
	
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
	
	public boolean withdraw(double value ) throws InsufficientFundsException {
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

}
