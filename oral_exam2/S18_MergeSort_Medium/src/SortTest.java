import java.util.Random;

/**
 * Main class for testing merge sort algorithm
 * @author Konnor Sommer
 */
public class SortTest {
    /**
     * Main method for testing merge sort algorithm.
     * Prints out a length 100 array of random integers less than 1000. Applies method mergeSort, then prints out sorted array.
     * @param args
     */
    public static void main(String args[]){
        Random rand = new Random();
        int[] testArray = new int[100];
        for(int i = 0; i<100; i++){
            testArray[i] = rand.nextInt(1000);
            System.out.print(testArray[i]+"  ");
        }
        MergeSort.mergeSort(testArray);
        System.out.println();
        for(int i = 0; i<100; i++){
            System.out.print(testArray[i]+"  ");
        }
    }
}
