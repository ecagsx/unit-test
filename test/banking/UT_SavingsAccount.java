package banking;

import banking.exceptions.InsufficientFundsException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class UT_SavingsAccount {
  private SavingsAccount account;

  @Test
  public void accrueInterest() {
    assertEquals(100, account.balance(), 0);
    account.accrueInterest();
    assertEquals(101.00, account.balance(), 0.01);
  }

  @Test
  public void accrueInterest_multipleCalls() {
    assertEquals(100, account.balance(), 0);
    account.accrueInterest();
    account.accrueInterest();
    account.accrueInterest();
    assertEquals(103.03, account.balance(), 0.01);
  }

  @Test
  public void deposit() {
    assertEquals(100, account.balance(), 0.01);
    account.deposit(5.50);
    assertEquals(105.50, account.balance(), 0.01);
  }

  @Ignore // Skips test
  @Test
  public void deposit_negativeAmount() {
    // TODO: Add handling for negative input in Account#deposit?
    account.deposit(-10);

    // assertTrue(90 == account.balance());  // Shouldn't be able to override withdraw method by passing negative input to deposit
  }

  @After // Executed after each @Test method.  Dealloate/"Reset" test environment.
  public void tearDown()
      throws Exception {
    account = null;
  }

  @Test
  public void transfer()
      throws InsufficientFundsException {
    Account sourceAccount = new Account(100);
    account.transfer(100, sourceAccount);

    assertEquals(200, account.balance(), 0);
    assertEquals(0, sourceAccount.balance(), 0);
  }

  @Test(expected = InsufficientFundsException.class)
  public void transfer_InsufficientFundsException()
      throws InsufficientFundsException {
    Account sourceAccount = new Account(100);
    account.transfer(101, sourceAccount);
  }

  @Before // Executed before each @Test method.  Allocate/initialize resources.
  public void setUp()
      throws Exception {
    account = new SavingsAccount(100);
  }
}
