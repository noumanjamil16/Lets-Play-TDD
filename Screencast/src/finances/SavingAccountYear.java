package finances;

public class SavingAccountYear {
	
	
	private int startingBalance = 0;
	private int interestRate;
	
	
	public SavingAccountYear() {
		
	}
	
	public SavingAccountYear(int startingBalance, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
	}
	
	
	public int startingBalance() {
		return startingBalance;
	}

	public int interestRate() {
		return interestRate;
	}


	public SavingAccountYear nextYear() {
		return new SavingAccountYear(this.endingBalance(),interestRate);
	}
	
	public int endingBalance() {
		return startingBalance + (startingBalance * interestRate/100) ;
	}

	public void withdraw(int amount) {
		startingBalance -=amount;
		
	}

	

}
