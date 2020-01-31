package br.com.bytebank.bytebanksystem.model;

import java.io.Serializable;

public class Authenticator implements Authenticable, Serializable {
	private static final long serialVersionUID = 1L;	
	private int password;

	@Override
	public void setPassword(int password) {
		this.password = password;
	}

	@Override
	public boolean validate(int password) {
		return this.password == password;
	}

}
