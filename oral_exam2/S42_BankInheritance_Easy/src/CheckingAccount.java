public class CheckingAccount extends Account {
    private final double overdraft;
    CheckingAccount(String holder, int number, double balance,double overD){
        super(holder, number, balance, "Checking");
        overdraft = overD;
    }
    @Override
    public void withdraw(double value){
        if ((getAccBalance()-value) < 0-overdraft){
            System.out.println("Withdraw exceeds overdraft limit of $"+overdraft);
        }
        else super.withdraw(value);
    }

}
