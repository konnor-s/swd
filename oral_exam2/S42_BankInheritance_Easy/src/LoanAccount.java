/**
 * Extends Account class for Loan Account
 * @author Konnor Sommer
 * @see Account
 */
public class LoanAccount extends Account {
    /**
     * Interest rate for loan.
     */
    private final double interestRate;

    /**
     * Construct loan account with account holder, number, balance, interest, and type.
     * @param holder account holder
     * @param number account number
     * @param balance account balance
     * @param interest loan interest
     */
    LoanAccount(String holder, int number, double balance,double interest){
        super(holder, number, balance, "Loan");
        this.interestRate = interest;
    }

    /**
     * Withdraw/make payment on loan to decrease the value of account.
     * @param value money to withdraw
     */
    @Override
    public void withdraw(double value){
        if (getAccBalance() - value <=0){//If the balance goes to 0, the loan is payed off
            System.out.println("Loan payed off");
            super.setAccBalance(0);
        }
        else super.withdraw(value);

    }

    /**
     * Update account with loan interest.
     * @see LoanAccount#interestRate
     */
    @Override
    public void update() {
        setAccBalance(getAccBalance() * (interestRate+1));
    }
}
