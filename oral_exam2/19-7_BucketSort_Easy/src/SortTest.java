import java.util.Scanner;

/**
 * Test class for BucketSort class
 * @author Konnor Sommer
 */
public class SortTest {
    /**
     * Tests method sort() from BucketSort
     * @param args
     */
    public static void main(String args[]){

        Scanner input = new Scanner(System.in);

        //Get length of input array and itnitialize
        System.out.println("How many numbers to enter?");
        int num = input.nextInt();
        int[] array = new int[num];

        //Read in numbers to array
        System.out.println("Enter numbers separated by a space");
        for (int i = 0 ; i < num ; i++ ) {
            array[i] = input.nextInt();
        }

        BucketSort b = new BucketSort(array);
        int[] r = b.sort();

        for(int i=0;i<r.length;i++) {
            System.out.print(r[i]+" ");
        }
    }
}
