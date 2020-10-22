public class LoanAccount extends Account {
    private final double interestRate;
    LoanAccount(String holder, int number, double balance,double interest){
        super(holder, number, balance, "Loan");
        this.interestRate = interest;
    }
    @Override
    public void update() {
        setAccBalance(getAccBalance() * (interestRate+1));
    }
}
