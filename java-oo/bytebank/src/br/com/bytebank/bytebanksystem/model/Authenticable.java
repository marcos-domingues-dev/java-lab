package br.com.bytebank.bytebanksystem.model;

public interface Authenticable {

	public void setPassword(int password);

	public boolean validate(int password);

}
