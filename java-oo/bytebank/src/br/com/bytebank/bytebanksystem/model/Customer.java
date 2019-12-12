package br.com.bytebank.bytebanksystem.model;

public class Customer {

	private String name;
	private String cpf;
	private String address;
	private Authenticable auth;

	public Customer() {
		this.auth = new Authenticator();
		this.auth.setPassword(222);
	}

	public Authenticable getAuth() {
		return auth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getAddress() {
		return address;
	}

	public void setEndereco(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return
			"name=" + this.getName() + " " +
			"cpf" + this.getCpf() + " " +
			"adress=" + this.getAddress();				
				
	}
}
