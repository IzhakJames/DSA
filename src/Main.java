
import Linear.util.PairCounters;
import Searching.Search;
import Sorting.InsertionSort;
import Sorting.MergeSort;
import Sorting.QuickSort;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,8,3,4,6,1,10,7};
        QuickSort qs = new QuickSort();
        qs.sort(arr);
        System.out.println("Sorted array :" + Arrays.toString(arr));

        Search searcher = new Search();
        System.out.println(searcher.binarySearchRec(arr, 1));

//        System.out.println(PairCounters.getFibonacci(5));

    }
}