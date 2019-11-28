package br.com.bytebank.bytebanksystem.model;

public class LocalSystem {

	public boolean login(Authenticable auth) {
		return auth.validate(222);
	}
}
