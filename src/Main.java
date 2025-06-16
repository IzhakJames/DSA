import LeetCode.arrays.*;
import LeetCode.arrays.slidingWindow.MinAbsDifference;
import LeetCode.arrays.slidingWindow.MinSizeSubArrSum;
import LeetCode.arrays.twoPointers.BestTimeToBuyStock;
import LeetCode.arrays.twoPointers.LongestMountainInArray;
import LeetCode.arrays.twoPointers.SquaresOfSortedArr;
import LeetCode.arrays.twoPointers.ThreeSum;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MinSizeSubArrSum solution = new MinSizeSubArrSum();
        int[] arr = {10,5,13,4,8,4,5,11,14,9,16,10,20,8};

        System.out.println(solution.solutionQ209(arr, 80));


    }

}