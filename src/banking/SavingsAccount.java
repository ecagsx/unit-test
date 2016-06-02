package banking;

public class SavingsAccount extends Account {
  double interestRate;

  public SavingsAccount(double amount) {
    super(amount);
    interestRate = 0.01;
  }

  public void accrueInterest() {
    balance = balance + (balance * interestRate);
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double rate) {
    interestRate = rate;
  }
}
