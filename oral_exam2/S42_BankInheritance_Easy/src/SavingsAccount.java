public class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(String holder, int number, double balance, double interest){
        super(holder, number, balance, "Savings");
        interestRate = interest;

    }

    @Override
    public void update() {
        setAccBalance(getAccBalance() * (interestRate+1));
    }
}
