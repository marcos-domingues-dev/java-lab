
public class Authenticator implements Authenticable {

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
