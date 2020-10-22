public class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String holder, int number, double balance, double interest){
        super(holder, number, balance);
        interestRate = interest;
    }

}
