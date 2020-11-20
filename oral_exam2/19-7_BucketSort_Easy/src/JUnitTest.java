import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * JUnit testing class for method sort().
 * @author Konnor Sommer
 * @see BucketSort#sort()
 */
public class JUnitTest {
    /**
     * Tests method sort() on a variety of different arrays.
     * This tests on 10 different arrays, each of which has unique values in unique orders, with varying sizes.
     * These tests should sufficiently show that the sort() method is working correctly for the range of all possible input arrays.
     */
    @Test
    void testSort(){
        int[] orig1 = new int[]{9,2,50,9000,1};
        int[] sorted1 = new int[]{1,2,9,50,9000};
        BucketSort test1 = new BucketSort(orig1);
        assertArrayEquals(sorted1, test1.sort());

        int[] orig2 = new int[]{1,2,9,50,9000};
        int[] sorted2 = new int[]{1,2,9,50,9000};
        BucketSort test2 = new BucketSort(orig2);
        assertArrayEquals(sorted2, test2.sort());

        int[] orig3 = new int[]{10000,1000,100,10,1};
        int[] sorted3 = new int[]{1,10,100,1000,10000};
        BucketSort test3 = new BucketSort(orig3);
        assertArrayEquals(sorted3, test3.sort());

        int[] orig4 = new int[]{5,93,5,684,87412,684};
        int[] sorted4 = new int[]{5,5,93,684,684,87412};
        BucketSort test4 = new BucketSort(orig4);
        assertArrayEquals(sorted4, test4.sort());

        int[] orig5 = new int[]{684,1568,981,384,189,35,18,6841};
        int[] sorted5 = new int[]{18,35,189,384,684,981,1568,6841};
        BucketSort test5 = new BucketSort(orig5);
        assertArrayEquals(sorted5, test5.sort());

        int[] orig6 = new int[]{31,68,391,4286,352,463,315,48651};
        int[] sorted6 = new int[]{31,68,315,352,391,463,4286,48651};
        BucketSort test6 = new BucketSort(orig6);
        assertArrayEquals(sorted6, test6.sort());

        int[] orig7 = new int[]{68351,65113,2,36547,52146,321};
        int[] sorted7 = new int[]{2,321,36547,52146,65113,68351};
        BucketSort test7 = new BucketSort(orig7);
        assertArrayEquals(sorted7, test7.sort());

        int[] orig8 = new int[]{5,81,35,48,651,48,2,1,9,65,48,21,961,55,1,3,165,1235,452};
        int[] sorted8 = new int[]{1,1,2,3,5,9,21,35,48,48,48,55,65,81,165,452,651,961,1235};
        BucketSort test8 = new BucketSort(orig8);
        assertArrayEquals(sorted8, test8.sort());

        int[] orig9 = new int[]{99,98,97,91,93,94,95,92,96,90};
        int[] sorted9 = new int[]{90,91,92,93,94,95,96,97,98,99};
        BucketSort test9 = new BucketSort(orig9);
        assertArrayEquals(sorted9, test9.sort());

        int[] orig10 = new int[]{987,654,321,789,456,123,1,9999,57};
        int[] sorted10 = new int[]{1,57,123,321,456,654,789,987,9999};
        BucketSort test10 = new BucketSort(orig10);
        assertArrayEquals(sorted10, test10.sort());


    }
}
