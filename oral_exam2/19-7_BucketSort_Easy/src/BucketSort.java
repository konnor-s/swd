/**
 * Implements a bucket sort algorithm for an input array of positive integers.
 * @author Konnor Sommer
 */
public class BucketSort {
    /**
     * Array with original input values being sorted.
     */
    private int[] sortArray;
    /**
     * Length of input array
     */
    private int n;
    /**
     * Array which helps get correct digit for putting in bucket.
     * This holds values in same order as sortArray which are divided by 10 each iteration to help get the least significant digit.
     * For example, 1234 in sortArray will start as 1234 in tempArray the first iteration, then change to 123, 12 and 1.
     */
    private int[] tempArray;
    /**
     * Keeps track of how many recursive iterations have occurred
     */
    private int iter=0;

    /**
     * Constructs the arrays and gets the length for sorting this array.
     * @param x input array to be sorted
     */
    BucketSort(int[] x){
        n = x.length;
        sortArray = x.clone();
        tempArray = sortArray.clone();
    }

    /**
     * Sort's this array's values into ascending order using bucket sorting.
     * @return sorted integer array
     */
    public int[] sort(){
        int digit;
        boolean done=true;
        iter++;
        //reinitialize each iteration to clear values
        int[][] bucketArray = new int[10][n];

        //get last digit of tempArray, set the corresponding number in sortArray to this digit's row in bucketArray
        for (int i = 0;i<sortArray.length;i++){
            digit = tempArray[i]%10;
            bucketArray[digit][i]=sortArray[i];
        }
        int n =0;
        //find positive integers in bucketArray and move them to sortArray
        for(int i=0;i<10;i++){
            for(int j=0;j<sortArray.length;j++){
                if (bucketArray[i][j]>0){
                    //System.out.println(bucketArray[i][j]);
                    sortArray[n]=bucketArray[i][j];
                    //System.out.println(sortArray[n]);
                    n++;
                }
            }
        }
       //set tempArrays values to sortArray's divided by (10*number of iterations).
        // This makes it so the next iteration, the sortArray values can be placed into buckkets based on the next most significant digit.
        //If all of the values in the new tempArray are 0, then exit the program since the values have all been sorted.
        for (int i=0;i<tempArray.length;i++) {
            tempArray[i] = sortArray[i] / (10*iter);
            if(tempArray[i]!=0){done=false;}

        }
        //If there are still larger numbers to sort, recursively call this function.
        //The recursive call will use the new tempArray to sort the next most significant digit
        if(done==false){
            sort();
        }
        return sortArray;
    }
}
