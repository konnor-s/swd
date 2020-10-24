/**
 * Extends Account class for a Savings account.
 * @author Konnor Sommer
 * @see Account
 */
public class SavingsAccount extends Account {
    /**
     * Interest rate of this savings account
     */
    private double interestRate;

    /**
     * Constructs new savings account with account holder, number, balance, interest rate, and type.
     * @param holder account holder
     * @param number account number
     * @param balance account balance
     * @param interest savings interest rate
     */
    SavingsAccount(String holder, int number, double balance, double interest){
        super(holder, number, balance, "Savings");
        interestRate = interest;

    }

    /**
     * Updates the account by applying the interest rate.
     * @see SavingsAccount#interestRate
     */
    @Override
    public void update() {
        setAccBalance(getAccBalance() * (interestRate+1));
    }
}
