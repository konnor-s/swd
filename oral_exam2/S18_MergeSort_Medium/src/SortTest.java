import java.util.Random;

public class SortTest {
    public static void main(String args[]){
        Random rand = new Random();
        int[] testArray = new int[100];
        for(int i = 0; i<100; i++){
            testArray[i] = rand.nextInt(1000);
            System.out.println(testArray[i]);
        }
        MergeSort.mergeSort(testArray);
        for(int i = 0; i<100; i++){
            System.out.println(testArray[i]);
        }
    }
}
