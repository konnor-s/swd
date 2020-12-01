
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit testing class for method mergeSort().
 * @author Konnor Sommer
 * @see MergeSort#mergeSort(int[])
 */
public class JUnitTest {
    /**
     * Tests method mergeSort() on a variety of different arrays.
     * This tests on 10 different arrays, each with random values and different lengths.
     * These tests should sufficiently show that the mergeSort() method is working correctly for the range of all possible input arrays.
     */
    @Test
    void testSort(){
        Random rand = new Random();

        int n = 9;
        int[] test1= new int[n];
        for(int i = 0; i<n; i++){
            test1[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test1);
        for(int i = 0; i<n-1;i++){
            assertTrue(test1[i]<=test1[i+1]);
        }

        n = 25;
        int[] test2= new int[n];
        for(int i = 0; i<n; i++){
            test2[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test2);
        for(int i = 0; i<n-1;i++){
            assertTrue(test2[i]<=test2[i+1]);
        }

        n = 52;
        int[] test3= new int[n];
        for(int i = 0; i<n; i++){
            test3[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test3);
        for(int i = 0; i<n-1;i++){
            assertTrue(test3[i]<=test3[i+1]);
        }

        n = 53;
        int[] test4= new int[n];
        for(int i = 0; i<n; i++){
            test4[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test4);
        for(int i = 0; i<n-1;i++){
            assertTrue(test4[i]<=test4[i+1]);
        }

        n = 64;
        int[] test5= new int[n];
        for(int i = 0; i<n; i++){
            test5[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test5);
        for(int i = 0; i<n-1;i++){
            assertTrue(test5[i]<=test5[i+1]);
        }

        n = 71;
        int[] test6= new int[n];
        for(int i = 0; i<n; i++){
            test6[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test6);
        for(int i = 0; i<n-1;i++){
            assertTrue(test6[i]<=test6[i+1]);
        }

        n = 78;
        int[] test7= new int[n];
        for(int i = 0; i<n; i++){
            test7[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test7);
        for(int i = 0; i<n-1;i++){
            assertTrue(test7[i]<=test7[i+1]);
        }

        n = 84;
        int[] test8= new int[n];
        for(int i = 0; i<n; i++){
            test8[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test8);
        for(int i = 0; i<n-1;i++){
            assertTrue(test8[i]<=test8[i+1]);
        }

        n = 92;
        int[] test9= new int[n];
        for(int i = 0; i<n; i++){
            test9[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test9);
        for(int i = 0; i<n-1;i++){
            assertTrue(test9[i]<=test9[i+1]);
        }

        n = 100;
        int[] test10= new int[n];
        for(int i = 0; i<n; i++){
            test10[i] = rand.nextInt(1000);
        }
        MergeSort.mergeSort(test10);
        for(int i = 0; i<n-1;i++){
            assertTrue(test10[i]<=test10[i+1]);
        }
    }
}
