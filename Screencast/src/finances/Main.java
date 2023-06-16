package finances;

public class Main {

	public static void mian(String [] args) {
		SavingAccount account = new SavingAccount();
		account.deposit(10000);
		for(int i=0;i<60;i++) {
			System.out.println(i + " : $" + account.balance());
			account = account.nextYear(10);
		}
	}
}
