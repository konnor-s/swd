public class Account {
    double accBalance;
    int accNumber;
    String accHolder;

    Account(String holder, int number, double balance){
        accBalance = balance;
        accNumber = number;
        accHolder = holder;
    }

    public void deposit(int value){
        accBalance += value;
    }
    public void withdraw(double value){
        accBalance -= value;
    }
}
