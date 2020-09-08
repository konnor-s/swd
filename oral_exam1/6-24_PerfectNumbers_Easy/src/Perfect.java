/**
 * Class which implements perfect number functions.
 * @author Konnor Sommer
 * @version %I%, %G%
 *  */

public class Perfect {
    /**
     * Tests whether an input number is perfect
     * Returns a boolean indicating whether the number is perfect
     * @param x     The number to test
     * @return      True if number is perfect, else false
     */

    public static boolean isPerfect(int x){
        int sum=1;//sum starts at 1
        for(int i=2;i<=Math.sqrt(x);i++){//test for factors starting at 2 going to the numbers square root so that factors wont repeat. Excludes the number and 1.
            if(x%i==0){
                sum+=(x/i+i);
            }
        }
        return (sum==x) && (x!=1);//Exclude 1 from perfect numbers
    }

    /**
     * Prints the factors of an input number
     * @param x     The number of which to print factors
     */
    public static void printFactors(int x){
        System.out.printf("1");//first factor is 1
        for(int i=2;i<x;i++) {//test for factors starting at 2 until x, printing each as it goes
            if (x % i == 0) {
                System.out.printf(" + %d",i);
            }
        }
    }
}
