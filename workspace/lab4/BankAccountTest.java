import junit.framework.TestCase;


public class BankAccountTest extends TestCase {
	public void testInit() {
		BankAccount thai = new BankAccount (100);
        assertTrue (thai.balance() == 100);
    }
	
	public void testInvalidArgs() {
		BankAccount thai = new BankAccount(100);
		thai.deposit(-20);
		assertTrue(thai.balance()== 100);	
	}
	
	public void testOverdraft() {
		BankAccount thai = new BankAccount(100);
		thai.withdraw(200);
		assertTrue(thai.balance() == 100);	
	}
	
	public void testDeposit() {
		BankAccount thai = new BankAccount(100);
		thai.deposit(50);
		assertTrue(thai.balance()== 150);	
	}
	
	public void testWidthdraw() {
		BankAccount thai = new BankAccount(100);
		thai.withdraw(40);
		assertTrue(thai.balance()== 60);	

	}
	

}
