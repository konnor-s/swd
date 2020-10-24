/**
 * Extends Account class for Checking Account
 * @author Konnor Sommer
 * @see Account
 */
public class CheckingAccount extends Account {
    /**
     * Overdraft limit
     */
    private final double overdraft;

    /**
     * Constructs new savings account with account holder, number, balance, overdraft limit, and type.
     * @param holder account holder
     * @param number account number
     * @param balance account balance
     * @param overD overdraft limit
     */
    CheckingAccount(String holder, int number, double balance,double overD){
        super(holder, number, balance, "Checking");
        overdraft = overD;
    }

    /**
     * Withdraw money only if the withdraw doesn't exceed the overdraft limit.
     * @param value money to withdraw
     */
    @Override
    public void withdraw(double value){
        if ((getAccBalance()-value) < 0-overdraft){//Only withdraw to overdraft limit
            System.out.println("Withdrawl exceeds overdraft limit of $"+overdraft);
            super.setAccBalance(0-overdraft);
        }
        else super.withdraw(value);
    }

    /**
     * No interest is applied to a checking account, so no update occurs.
     */
    @Override
    public void update(){}

}
