import Graph.MyWeightedGraph;
import Sorting.BubbleSort;
import Sorting.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {2,8,3,4,6,1};
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
        System.out.println("Sorted array :" + Arrays.toString(arr));
    }
}