
public class AccountTester {

	public static void main(String[] args) {

		Customer vipCustomer = new Customer();
		vipCustomer.setName("Capitão América");
		Account vpSavingsAccount = new SavingsAccount(100, 333, vipCustomer);
		Account vpCheckingAccount = new CheckingAccount(100, 444, vipCustomer);
		vpSavingsAccount.deposit(400);
		vpCheckingAccount.deposit(1000);
		vpCheckingAccount.transfers(50, vpSavingsAccount);
		
		Customer newHeroe = new Customer();
		newHeroe.setName("Gost Hider");
		Account hSavingsAccount = new SavingsAccount(888, 741, newHeroe);
		Account hCheckingAccount = new CheckingAccount(888, 742, newHeroe);
		hSavingsAccount.deposit(8000);
		hCheckingAccount.deposit(9000);
		hCheckingAccount.transfers(30, hSavingsAccount);
		
		System.out.println("Vip Savings: "+ vpSavingsAccount.getBalance());
		System.out.println("Vip Checking: " + vpCheckingAccount.getBalance());
		System.out.println("Heroe Savings: "+ hSavingsAccount.getBalance());
		System.out.println("Heroe Checking: " + hCheckingAccount.getBalance());		
		
	}
}
