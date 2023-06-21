package finances;

public class SavingAccountYear {
	
	
	private int startingBalance = 0;
	private int interestRate = 0;
	private int capitalGainsAmount = 0;
	private int startingPrincipal = 0;
	int totalWithdrawn = 0;
	
	
	public SavingAccountYear() {
		
	}
	
	public SavingAccountYear(int startingBalance, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
	}
	
	public SavingAccountYear(int startingBalance,int startingPrincipal, int interestRate) {
		this.startingBalance = startingBalance;
		this.interestRate = interestRate;
		this.startingPrincipal = startingPrincipal;
		this.capitalGainsAmount = startingBalance - startingPrincipal;
	}
	
	public int startingBalance() {
		return startingBalance;
	}
	
	public int startingPrincipal() {
		System.out.println("starting balance : " + startingBalance);
		System.out.println("Capital Gains : " + capitalGainsAmount);
		return startingBalance - capitalGainsAmount;
	}
	
	public int endingPrincipal() {
		int result = startingPrincipal() - totalWithdrawn();
		return Math.max(0, result);
	}
	
	public int endingBalance(int capitalGainsTaxRate) {
		int modifiedStart = startingBalance - totalWithdrawn() - capitalGainsTaxIncurred(capitalGainsTaxRate);
		return modifiedStart + (modifiedStart * interestRate/100) ;
	}

	public void withdraw(int amount ) {
		this.totalWithdrawn +=amount;
		
	}

	public int interestRate() {
		return interestRate;
	}

	public SavingAccountYear nextYear(int capitalGainsNextYear) {
		return new SavingAccountYear(this.endingBalance(capitalGainsNextYear),interestRate);
	}

	public int totalWithdrawn() {
		return totalWithdrawn;
	}

	public int capitalGainsWithDrawn() {
		int result = -1 * (startingPrincipal() - totalWithdrawn());
		return Math.max(0, result);
	}

	public int capitalGainsTaxIncurred(int taxRate) {
		double dblTaxRate = taxRate/100.0;
		double dblCapGains = capitalGainsWithDrawn();
		return (int)((dblCapGains /(1-dblTaxRate)) - dblCapGains);
	}
	
	

	

}
