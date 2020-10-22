public class Account {
    private double accBalance;
    private final int accNumber;
    private final String accHolder;
    private final String accType;

    Account(String holder, int number, double balance,String type){
        accBalance = balance;
        accNumber = number;
        accHolder = holder;
        accType = type;
    }
    public void update(){

    }

    public double getAccBalance(){
        return accBalance;
    }
    protected void setAccBalance(double bal){
        accBalance = bal;
    }

    public void deposit(double value){
        accBalance += value;
    }
    public void withdraw(double value){
        accBalance -= value;
    }
    public String getAccType(){
        return accType;
    }
}
