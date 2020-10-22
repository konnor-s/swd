public class CheckingAccount extends Account {
    final double overdraft;
    CheckingAccount(String holder, int number, double balance,double overD){
        super(holder, number, balance);
        overdraft = overD;
    }
}
