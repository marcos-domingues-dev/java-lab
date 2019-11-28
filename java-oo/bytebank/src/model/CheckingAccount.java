package model;

public class CheckingAccount extends Account {

	public CheckingAccount(int agency, int number, Customer owner) {
		super(agency, number, owner);
	}
	
	@Override
	public boolean withdraw(double value) throws InsufficientFundsException {
		double taxedValue = value + 0.30;
		return super.withdraw(taxedValue);
	}
}
