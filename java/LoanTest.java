import edu.bank.*;

public class LoanTest {
    public static void main(String[] args) {
        Loan homeLoan = new HomeLoan(500000, 7.5, 15);
        Loan carLoan = new CarLoan(800000, 9.0, 5);

        homeLoan.calculateInterest();
        carLoan.calculateInterest();
    }
}
