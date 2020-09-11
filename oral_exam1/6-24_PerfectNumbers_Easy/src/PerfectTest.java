/**
 * Class which tests for perfect numbers between 1 and 10000
 * Implements methods from class Perfect
 * @author Konnor Sommer
 */
public class PerfectTest{
    /**
     * Main function which tests for perfect numbers between 1 and 10000
     * @param args
     */
    public static void main(String[] args){
        System.out.print("Perfect numbers between 1 and 10,000:");
        for(int i=1;i<=10000;i++)//test numbers between 1 and 10,000
            if(Perfect.isPerfect(i)){//test whether the number is perfect. If it is, print it, then run the printFactors function to print its factors
                System.out.printf("%n%d: ",i);
                Perfect.printFactors(i);
            }
    }
}