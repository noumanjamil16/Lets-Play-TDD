package finances;

import static org.junit.Assert.*;

import org.junit.Test;

public class _SavingAccountYearTest {

	

	@Test
	public void startingBalance() {
		SavingAccountYear  account = newAccount();
		assertEquals(10000,account.startingBalance());
	}
	
	@Test
	public void interestRate() {
		SavingAccountYear year  = newAccount();
		assertEquals(10,year.interestRate());
	}
	
	@Test
	public void endingBalance() {
		SavingAccountYear account = newAccount();
		assertEquals(11000,account.endingBalance(25));
	}
	
	@Test
	public void nextYearStartingBalanceEqualsToLastYearEndingBalance() {
		SavingAccountYear thisYear = newAccount();
		assertEquals(11000,thisYear.nextYear(25).startingBalance());
	}
	
	@Test
	public void thisYearInterestRateEqualsToNextYearInterstRate() {
		SavingAccountYear currentYear = newAccount();
		assertEquals(currentYear.interestRate(),currentYear.nextYear(25).interestRate());
	}
	
	private SavingAccountYear newAccount() {
		return  new SavingAccountYear(10000,10);
	}
	
	@Test
	public void withDrawFundsOccurAtTheBeginingOfTheYear() {
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		assertEquals(9900,year.endingBalance(25));
	}
	
	@Test
	public void startingPrincipal() {
		SavingAccountYear year = new SavingAccountYear(10000,3000,10);
		assertEquals(3000, year.startingPrincipal());
	}
	
	@Test
	public void endingPrincipal() {
		SavingAccountYear year = new SavingAccountYear(10000,3000,10);
		assertEquals("starting principal", 3000, year.startingPrincipal());
		year.withdraw(2000);
		assertEquals("ending principal",1000, year.endingPrincipal());
	}
	
	
	@Test
	public void endingPrincipalNeverGoesBelowZero() {
		SavingAccountYear year = new SavingAccountYear(10000,3000,10);
		assertEquals("starting principal", 3000, year.startingPrincipal());
		year.withdraw(4000);
		assertEquals("ending principal",0, year.endingPrincipal());
	}
	
	@Test
	public void multipleWithdrawsInYear() {
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		year.withdraw(2000);
		assertEquals(3000,year.totalWithdrawn());
	}
	
	@Test
	public void capitalGainsWithdrawn() {
		SavingAccountYear year  = new SavingAccountYear(10000,3000,10);
		assertEquals("starting principal",3000, year.startingPrincipal());
		year.withdraw(1000);
		assertEquals(0,year.capitalGainsWithDrawn());
		year.withdraw(3000);
		assertEquals(1000,year.capitalGainsWithDrawn());
	}
	
	@Test
	public void capitalGainTaxInurred() {
		SavingAccountYear year  = new SavingAccountYear(10000,3000,10);
		year.withdraw(5000);
		assertEquals(2000,year.capitalGainsWithDrawn());
		assertEquals(500,year.capitalGainsTaxIncurred(25));
	}
	
	@Test
	public void capitalGaisTaxIncludedInEndingBalance() {
		SavingAccountYear year = new SavingAccountYear(10000,3000,10);
		year.withdraw(5000);
		assertEquals(500, year.capitalGainsTaxIncurred(25));
		assertEquals(10000-5000-500+450,year.endingBalance(25));
	
		// TODO: Need to withdraw enough money to cover capital gains tax; that money will also be taxed
	
	}
	
	
	
//	@Test
//	public void withdrawMoreThanPriniciaplInursCapitalGains() {
//		SavingAccountYear year = new SavingAccountYear(10000,3000,10);
//		year.withdraw(3000);
//		assertEquals(7700,year.endingBalance());
//		year.withdraw(5000);
//		assertEquals(2000+200-(1250 * .25) , year.endingBalance());
//	
//	}
	
	

}
