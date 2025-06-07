package LeetCode.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountOfSmallerNumsThanCurrent {
    public int[] solutionQ1365(int[] arr) {
        int[] sortArr = (Arrays.copyOf(arr, arr.length));
        Arrays.sort(sortArr);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<sortArr.length;i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], i);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
