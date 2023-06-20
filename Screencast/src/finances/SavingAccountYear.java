package finances;

public class SavingAccountYear {
	
	
	private int startingBalance = 0;
	private int interestRate = 0;
	private int capitalGainsAmount = 0;
	int totalWithdrawn = 0;
	
	
	public SavingAccountYear() {
		
	}
	
	public SavingAccountYear(int startingBalance, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
	}
	
	public SavingAccountYear(int startingBalance,int capitalGainsAmount, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
		this.capitalGainsAmount = capitalGainsAmount;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public int startingPrincipal() {
		return startingBalance - capitalGainsAmount;
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal() - totalWithdrawn;
		return (result < 0) ? 0 : result;
	}
	
	public int endingBalance() {
		int modifiedStart = startingBalance - totalWithdrawn;
		return modifiedStart + (modifiedStart * interestRate/100) ;
	}

	public void withdraw(int amount ) {
		this.totalWithdrawn +=amount;
		
	}

	public int interestRate() {
		return interestRate;
	}

	public SavingAccountYear nextYear() {
		return new SavingAccountYear(this.endingBalance(),interestRate);
	}
	
	

	

}
