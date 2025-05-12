
import Sorting.InsertionSort;
import Sorting.MergeSort;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,8,3,4,6,1,7,10};
        MergeSort ms = new MergeSort();
        ms.sort(arr);
        System.out.println("Sorted array :" + Arrays.toString(arr));
    }
}