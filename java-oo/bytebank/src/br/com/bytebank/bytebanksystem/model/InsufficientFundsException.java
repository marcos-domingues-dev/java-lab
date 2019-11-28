package br.com.bytebank.bytebanksystem.model;

public class InsufficientFundsException extends Exception {

	public InsufficientFundsException(String msg) {
		super(msg);
	}
}
