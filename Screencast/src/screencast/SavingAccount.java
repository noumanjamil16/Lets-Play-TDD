package screencast;

public class SavingAccount {

	private int balance = 0;
	
	public int balance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public void deposit(int amount) {
		// TODO Auto-generated method stub
		balance += amount;
	}

	public void withdraw(int amount) {
		// TODO Auto-generated method stub
		balance -= amount;
	}

}
