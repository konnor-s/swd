/**
 * Class to test functionality of different account types.
 * @author Konnot Sommer
 */
public class BankTest {
    /**
     * Tests functionality of different account types and opens the banker interface.
     * @param args
     */
    public static void main(String args[]){
        //Test saving account
        System.out.println("Savings account created with name = Jerry Smith, number = 123, balance = 100.00, interest rate = .1)");
        SavingsAccount sAccount = new SavingsAccount("Jerry Smith",123,100.00,.1);
        System.out.println("Account Holder: "+sAccount.getAccHolder()+"\nAccount number: "+ sAccount.getAccNumber()+"\nAccount type: "+sAccount.getAccType());
        double old = sAccount.getAccBalance();
        sAccount.update();
        System.out.println("Account updated with interest.\nOld balance: "+old+"\nNew balance: "+sAccount.getAccBalance());
        sAccount.deposit(50);
        System.out.println("Deposit of $50 made.\nNew balance: "+sAccount.getAccBalance());
        sAccount.withdraw(10);
        System.out.println("Withdrawl of $10 made.\nNew balance: "+sAccount.getAccBalance());

        //test checking account
        System.out.println("\nChecking account created with name = Greg Jones, number = 124, balance = 90.00, overdraft limit = 50.00)");
        CheckingAccount cAccount = new CheckingAccount("Greg Jones",124,90.00,50.00);
        System.out.println("Account Holder: "+cAccount.getAccHolder()+"\nAccount number: "+ cAccount.getAccNumber()+"\nAccount type: "+cAccount.getAccType());
        old = cAccount.getAccBalance();
        cAccount.deposit(10);
        System.out.println("Deposit of $10 made.\nOld balance: "+old+"\nNew balance: "+cAccount.getAccBalance());
        System.out.println("Withdrawl of $160 made.");
        cAccount.withdraw(160);
        System.out.println("New balance: "+cAccount.getAccBalance());

        //test loan account
        LoanAccount lAccount = new LoanAccount("Jimmy Bob",125,240.00,.2);
        System.out.println("\nChecking account created with name = Jimmy Bob, number = 125, balance = 240.00, loan interest = .2)");
        System.out.println("Account Holder: "+lAccount.getAccHolder()+"\nAccount number: "+ lAccount.getAccNumber()+"\nAccount type: "+lAccount.getAccType());
        old = lAccount.getAccBalance();
        lAccount.withdraw(200.0);
        System.out.println("Payment of $200 made.\nOld balance: "+old+"\nNew balance: "+lAccount.getAccBalance());
        lAccount.update();
        System.out.println("Account updated with interest.\nNew balance: "+lAccount.getAccBalance());
        System.out.println("Payment of $48 made.");
        lAccount.withdraw(48);
        System.out.println("New balance: " + lAccount.getAccBalance());

        //open banker interface
        Bank.BankerInterface();
    }
}
