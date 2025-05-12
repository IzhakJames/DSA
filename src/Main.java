
import Sorting.InsertionSort;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,8,3,4,6,1};
        InsertionSort is = new InsertionSort();
        is.sort(arr);
        System.out.println("Sorted array :" + Arrays.toString(arr));
    }
}