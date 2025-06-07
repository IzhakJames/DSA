package LeetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public int[] solutionQ1(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) {
                return new int[]{map.get(target-arr[i]), i};
            }
            map.put(arr[i], i);
        }
        return null;
    }
}
