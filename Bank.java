
class LowBalanceException extends Exception {
    LowBalanceException(String message) {
        super(message);
    }
}

public class Bank {
    public static void main(String[] args) {
        int balance = 1000; // Initial balance
        int withdrawAmount = 500; //Changed from 1500 to 500

        try {
            if (withdrawAmount > balance) {
                // Throw custom exception
                throw new LowBalanceException("Insufficient balance to withdraw!");
            } else {
                balance -= withdrawAmount;
                System.out.println("Withdrawal successful! Remaining balance: " + balance);
            }
        } 
        catch (LowBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        } 
        finally {
            System.out.println("Thank you for using our banking service!");
        }
    }
}