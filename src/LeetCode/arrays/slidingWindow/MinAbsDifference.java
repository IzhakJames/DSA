package LeetCode.arrays.slidingWindow;

import java.util.*;

public class MinAbsDifference {
    public List<List<Integer>> solutionQ1200(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            int currMin = arr[i] - arr[i-1];
            min = Math.min(min, currMin);
        }
        for (int j = 1; j < arr.length; j++) {
            if (Math.abs(arr[j] - arr[j-1]) == min) {
                result.add(List.of(arr[j-1], arr[j]));
            }
        }
        return result;
    }
}
