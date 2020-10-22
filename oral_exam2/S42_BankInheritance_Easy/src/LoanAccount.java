public class LoanAccount extends Account {
    final  double interest;
    LoanAccount(String holder, int number, double balance,double interest){
        super(holder, number, balance);
        this.interest = interest;
    }
}
