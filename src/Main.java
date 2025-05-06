import Tree.MyAVLTree;
import Tree.MyMaxHeap;
import Tree.MyTree;
import Tree.util.MaxHeap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {5,3,8,4,1,2};
        int[] arr2 = {1,2,3,4,5,6};
        MaxHeap.heapify(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}