/**
 * Test class for BucketSort class
 */
public class SortTest {
    /**
     * Tests method sort() from BucketSort
     * @param args
     */
    public static void main(String args[]){
        int[] array = new int[]{5151,4499,3920,3920,10000};
        BucketSort b = new BucketSort(array);
        int[] r =b.sort();
        for(int i=0;i<r.length;i++) {
            System.out.println(r[i]);
        }

    }
}
