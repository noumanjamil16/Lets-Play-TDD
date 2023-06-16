package finances;

public class SavingAccount {

	private int balance = 0;
	
	public int balance() {
		return balance;
	}

	public void deposit(int amount) {
		balance += amount;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	public SavingAccount nextYear(int interestRate) {
		SavingAccount account = new SavingAccount();
		account.deposit(balance() + (balance() * interestRate/100));
		return account;
	}

}
