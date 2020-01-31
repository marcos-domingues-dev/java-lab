package br.com.bytebank.bytebanksystem.model;

/*import java.io.Serializable;*/

public class CheckingAccount extends Account /* implements Serializable*/ {
	private static final long serialVersionUID = 1L;

	public CheckingAccount(int agency, int number, Customer owner) {
		super(agency, number, owner);
	}

	@Override
	public boolean withdraw(double value) throws InsufficientFundsException {
		double taxedValue = value + 0.30;
		return super.withdraw(taxedValue);
	}
}
