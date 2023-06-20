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
		assertEquals(11000,account.endingBalance());
	}
	
	@Test
	public void nextYearStartingBalanceEqualsToLastYearEndingBalance() {
		SavingAccountYear thisYear = newAccount();
		assertEquals(11000,thisYear.nextYear().startingBalance());
	}
	
	@Test
	public void thisYearInterestRateEqualsToNextYearInterstRate() {
		SavingAccountYear currentYear = newAccount();
		assertEquals(currentYear.interestRate(),currentYear.nextYear().interestRate());
	}
	
	private SavingAccountYear newAccount() {
		return  new SavingAccountYear(10000,10);
	}
	
	@Test
	public void withDrawFundsOccurAtTheBeginingOfTheYear() {
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		assertEquals(9900,year.endingBalance());
	}
	
	@Test
	public void startingPrincipal() {
		SavingAccountYear year = new SavingAccountYear(10000,7000,10);
		assertEquals("starting principal", 3000, year.startingPrincipal());
	}
	
	@Test
	public void endingPrincipal() {
		SavingAccountYear year = new SavingAccountYear(10000,7000,10);
		assertEquals("starting principal", 3000, year.startingPrincipal());
		year.withdraw(2000);
		assertEquals("ending principal",1000, year.endingPrincipal());
	}
	
	
	@Test
	public void endingPrincipalNeverGoesBelowZero() {
		SavingAccountYear year = new SavingAccountYear(10000,7000,10);
		assertEquals("starting principal", 3000, year.startingPrincipal());
		year.withdraw(4000);
		assertEquals("ending principal",0, year.endingPrincipal());
	}
	
	@Test
	public void multipleWithdrawsInYear() {
		SavingAccountYear year = new SavingAccountYear(10000,10);
		year.withdraw(1000);
		year.withdraw(2000);
		assertEquals(7700,year.endingBalance());
	}
	
	
//	@Test
//	public void withdrawMoreThanPriniciaplInursCapitalGains() {
//		SavingAccountYear year = new SavingAccountYear(10000,7000,10);
//		year.withdraw(3000);
//		assertEquals(7700,year.endingBalance());
//		year.withdraw(5000);
//		assertEquals(2000+200-(1250 * .25) , year.endingBalance());
//	
//	}
	
	

}
