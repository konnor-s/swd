import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    public static void main(String args[]){
        boolean skip=false;
        int num;
        int index = 0;
        double oldBalance=0;
        double interest = 0;
        Scanner input=new Scanner(System.in);
        Account[] accounts;
        ArrayList<Integer> accts = new ArrayList<>();
        ArrayList<Account> acs = new ArrayList<Account>();
        System.out.println("Enter Account Number. Enter -1 to exit application.");
        num=input.nextInt();
        while(num>=0){

            if (!accts.contains(num)) {
                System.out.println("Create new account with number " + num + "? 1 for yes, 0 for no.");
                if (input.nextInt() == 1) {
                    accts.add(num);
                    input.nextLine();
                    System.out.println("Holder name?");
                    String name = input.nextLine();
                    System.out.println("Initial Balance?");
                    double bal = input.nextDouble();
                    System.out.println("Account type: \n 1: Savings \n 2: Checking \n 3. Loan");
                    int type = input.nextInt();
                    switch (type) {
                        case 1:
                            System.out.println("Interest rate?");
                            interest = input.nextDouble();
                            acs.add(new SavingsAccount(name, num, bal, interest));
                            break;

                        case 2:
                            System.out.println("Overdraft limit?");
                            double overD = input.nextDouble();
                            acs.add(new CheckingAccount(name, num, bal, overD));
                            break;
                        case 3:
                            System.out.println("Interest rate?");
                            interest = input.nextDouble();
                            acs.add(new LoanAccount(name, num, bal, interest));
                    }
                }
                else skip=true;
            }
            if (!skip) {
                for (int i = 0; i < accts.size(); i++) {//get index of current account
                    if (accts.get(i) == num) {
                        index = i;
                    }
                }
                oldBalance = (acs.get(index)).getAccBalance();//save old balance


                if ((acs.get(index)).getAccType()=="Savings"){

                }
                System.out.println("Choose account option: \n 1: Deposit \n 2: Withdraw/ Make loan payment \n 3: Update account with interest");
                int opt = input.nextInt();
                switch (opt) {
                    case 1:
                        System.out.println("Amount to deposit?");
                        double dep = input.nextDouble();
                        (acs.get(index)).deposit(dep);
                        break;
                    case 2:
                        System.out.println("Amount to withdraw?");
                        double wit = input.nextDouble();
                        (acs.get(index)).withdraw(wit);
                        break;
                    case 3:
                        (acs.get(index)).update();
                }
                System.out.println("Old Balance: " + oldBalance + "\nNew Balance: " + (acs.get(index)).getAccBalance());
            }
            System.out.println("Enter Account Number. Enter -1 to exit application.");
            num=input.nextInt();
        }


    }


}
