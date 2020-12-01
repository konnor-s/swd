import java.util.Arrays;

/**
 * Class which implements merge sort algorithm method.
 * @author Konnor Sommer
 */
public class MergeSort {
    /**
     * Sorts an input array of integers using a merge sort algorithm.
     * @param inpArray array of ints
     */
    public static void mergeSort(int[] inpArray){

        //Only sort again if the the array has multiple values
        if(inpArray.length >1) {
            //Create left and right subarrays
            int n = inpArray.length;
            int m = n / 2;
            int[] left = Arrays.copyOfRange(inpArray, 0, m);
            int[] right = Arrays.copyOfRange(inpArray, m, inpArray.length);

            //Recursively sort copies
            mergeSort(left);
            mergeSort(right);

            //Merge left and right arrays
            int l = 0; //left counter
            int r =  0; //right counter
            int k = 0; //main array counter
            //while i and j counters are both within their array, compare the right and left array values
            while ((l < m) & (r < (n - m))) {
                if (left[l] <= right[r]) {//if left is smaller, put it into the inpArray
                    inpArray[k++] = left[l++];//Increment counters for next loop
                }
                else {
                    inpArray[k++] = right[r++];
                }
            }
            //If one array has already been fully sorted in, sort the rest of the other array's values in
            while (l < m) {
                inpArray[k++] = left[l++];
            }
            while (r < n-m) {
                inpArray[k++] = right[r++];
            }
        }
    }
}
