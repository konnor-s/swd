import java.util.ArrayList;

/**
 * Sets up the parameters for a basic bank account.
 * @author Konnor Sommer
 *
 */
abstract public class Account {
    /**
     * The current balance of this account
     */
    private double accBalance;
    /**
     * The account number of this account
     */
    private final int accNumber;
    /**
     * The account holder of this account
     */
    private final String accHolder;
    /**
     * The account type of this account
     */
    private final String accType;
    /**
     * List of account numbers.
     * Used to access the object in accObjects.of the corresponding account number through the number's index.
     * @see Account#accObjects
     */
    private static ArrayList<Integer> accNums = new ArrayList<>();
    /**
     * List of account objects.
     * Accessed using the index of the corresponding account number in accNums.
     * @see Account#accNums
     *
     */
    private static ArrayList<Account> accObjects = new ArrayList<Account>();
    /**
     * Constructs a new account with the account's holder, number, balance, and type
     * @param holder account holder
     * @param number account number
     * @param balance initial balance
     * @param type account type
     */
    Account(String holder, int number, double balance,String type){
        accBalance = balance;
        accNumber = number;
        accHolder = holder;
        accType = type;
        accNums.add(number);
        accObjects.add(this);
    }

    /**
     * Reterns a reference to the Account object with this account number.
     * @param num account number
     * @return Account object
     */
    public static Account getAccount(int num){
        int index = 0;
        for (int i = 0; i < accNums.size(); i++) {//get index of current account
            if (accNums.get(i) == num) {
                index = i;
            }
        }
        return accObjects.get(index);
    }

    /**
     * Returns whether a number has a valid account associated with it.
     * @param num account number
     * @return boolean true or false
     */
    public static boolean isAccount(int num){
        return(accNums.contains(num));
    }
    /**
     * Update the account
     */
    abstract public void update();

    /**
     * Get the current account balance
     * @return account balance
     */
    public double getAccBalance(){
        return accBalance;
    }

    /**
     * Set the new account balance
     * @param bal new balance
     */
    public void setAccBalance(double bal){
        accBalance = bal;
    }

    /**
     * Deposit money into account
     * @param value money to deposit
     */
    public void deposit(double value){
        accBalance += value;
    }

    /**
     * Withdraw money from account
     * @param value money to withdraw
     */
    public void withdraw(double value){
        accBalance -= value;
    }

    /**
     * Get account type
     * @return account type
     */
    public String getAccType(){
        return accType;
    }

    /**
     * Get account holder
     * @return account holder
     */
    public String getAccHolder(){
        return accHolder;
    }

    /**
     * Get account number
     * @return account number
     */
    public int getAccNumber(){
        return accNumber;
    }
}
