package banking;

import banking.exceptions.InsufficientFundsException;

public class Account {
  protected double balance;

  public Account(double amount) {
    balance = amount;
  }

  public Account(Account account) {
    balance = account.balance();
  }

  public double balance() {
    return balance;
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void transfer(double amount, Account account)
      throws InsufficientFundsException {
    account.withdraw(amount);
    deposit(amount);
  }

  public void withdraw(double amount)
      throws InsufficientFundsException {
    if (checkSufficientFunds(amount)) {
      balance -= amount;
    }
    else {
      double needs = amount - balance;
      throw new InsufficientFundsException(needs);
    }
  }
  
  private boolean checkSufficientFunds(double amount) {
    return balance >= amount;
  }
}
