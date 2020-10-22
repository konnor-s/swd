import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {
    public static void main(String args[]){
        int num;
        double interest = 0;
        Scanner input=new Scanner(System.in);
        Account[] accounts;
        List<Integer> accts = new ArrayList<>();
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
                            SavingsAccount a = new SavingsAccount(name, num, bal, interest);
                            break;

                        case 2:
                            System.out.println("Overdraft limit?");
                            double overD = input.nextDouble();
                            CheckingAccount b = new CheckingAccount(name, num, bal, overD);
                            break;
                        case 3:
                            System.out.println("Interest rate?");
                            interest = input.nextDouble();
                            LoanAccount c = new LoanAccount(name, num, bal, interest);
                    }
                }
            }

            System.out.println("Enter Account Number. Enter -1 to exit application.");
            num=input.nextInt();
        }


    }
}
