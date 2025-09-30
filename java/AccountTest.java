abstract class Account {
    protected String accountNumber;
    protected double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void displayAccountType();

    void showBalance() {
        System.out.println("Account Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

       void displayAccountType() {
        System.out.println("Savings Account");
    }

    void addInterest() {
        balance += balance * interestRate / 100;
        System.out.println("Interest added.");
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    void displayAccountType() {
        System.out.println("Current Account");
    }

    void useOverdraft(double amount) {
        if (amount <= overdraftLimit) {
            balance -= amount;
            System.out.println("Overdraft used: " + amount);
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("SA123", 5000, 4.0);
        Account acc2 = new CurrentAccount("CA456", 10000, 2000);

        acc1.displayAccountType();
        acc1.showBalance();

        acc2.displayAccountType();
        acc2.showBalance();
    }
}
