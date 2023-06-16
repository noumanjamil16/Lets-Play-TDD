package finances;

import static org.junit.Assert.*;

import org.junit.Test;

public class _SavingAccountTest {

	@Test
	public void test() {
		SavingAccount account  = new SavingAccount();
		account.deposit(10000);
		assertEquals("after deposit",10000,account.balance()); 
		account.withdraw(5000);
		assertEquals("after withdraw",5000,account.balance());
	}
	
	@Test
	public void negativeBalanceIsFine() {
		SavingAccount account  = new SavingAccount();
		account.withdraw(7500);
		assertEquals(-7500,account.balance());
	}
	
	@Test
	public void nextYear() {
		SavingAccount account = new SavingAccount();
		account.deposit(10000);
		SavingAccount nextYear = account.nextYear(10);
		assertEquals(11000,nextYear.balance());
	}

}
