
import java.util.Scanner;

/**
 * Implements banker interface.
 * A banker can create new accounts of any type, and access any saved account.
 * The banker can make a deposit, withdraw, or update account with interest.
 * @see Account
 */
public class Bank {
    /**
     * Interface for a banker to create new accounts of any type, and access any saved account.
     * The banker can make a deposit, withdraw, or update account with interest.
     */
    public static void BankerInterface(){

        int num;
        double oldBalance=0;
        double interest = 0;
        Scanner input=new Scanner(System.in);

        //Loop to access accounts
        System.out.println("\nBanker interface opened.\nEnter Account Number. Enter -1 to exit application.");
        num=input.nextInt();
        while(num>=0){
            boolean skip=false;
            //If the account is not stored, prompt to create new account
            if (!Account.isAccount(num)) {
                System.out.println("Create new account with number " + num + "? 1 for yes, 0 for no.");
                if (input.nextInt() == 1) {
                    input.nextLine();

                    System.out.println("Holder name?");//Store holder's name
                    String name = input.nextLine();

                    System.out.println("Initial Balance?");//Store initial balance
                    double bal = input.nextDouble();

                    System.out.println("Account type: \n 1: Savings \n 2: Checking \n 3. Loan");//Select account type
                    int type = input.nextInt();

                    switch (type) {//Initialize account specific parameters, and create a new object of that account type
                        case 1:
                            System.out.println("Interest rate? (as decimal)");
                            interest = input.nextDouble();
                            new SavingsAccount(name, num, bal, interest);
                            break;

                        case 2:
                            System.out.println("Overdraft limit?");
                            double overD = input.nextDouble();
                            new CheckingAccount(name, num, bal, overD);
                            break;
                        case 3:
                            System.out.println("Interest rate? (as decimal)");
                            interest = input.nextDouble();
                            new LoanAccount(name, num, bal, interest);
                    }
                }
                else skip=true;//If they don't want to create a new account, skip the next section to access the account
            }
            if (!skip) {

                oldBalance = Account.getAccount(num).getAccBalance();//save old balance

                System.out.println("\nChoose " + Account.getAccount(num).getAccType()+" account option for holder "+Account.getAccount(num).getAccHolder()+", balance = "+Account.getAccount(num).getAccBalance()+"\n 1: Deposit/Take out loan \n 2: Withdraw/Make loan payment \n 3: Update account with interest");
                int opt = input.nextInt();

                switch (opt) {//Choose what you want to do with the account
                    case 1:
                        System.out.println("Amount to deposit?");
                        double dep = input.nextDouble();
                        Account.getAccount(num).deposit(dep);
                        break;
                    case 2:
                        System.out.println("Amount to withdraw/Amount to pay on loan?");
                        double wit = input.nextDouble();
                        Account.getAccount(num).withdraw(wit);
                        break;
                    case 3:
                        Account.getAccount(num).update();
                }
                System.out.println("Old Balance: " + oldBalance + "\nNew Balance: " + Account.getAccount(num).getAccBalance());
            }
            System.out.println("Enter Account Number. Enter -1 to exit application.");
            num=input.nextInt();
        }


    }


}
