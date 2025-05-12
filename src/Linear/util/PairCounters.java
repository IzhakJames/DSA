package Linear.util;

import java.util.HashMap;
import java.util.Map;

public class PairCounters {
    public static int countPairsWithDiff(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int result = 0;
        for (int j : arr) {
            if (map.containsKey(j + diff)) {
                result += 1;
            }
        }
        return result;
    }

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int num : arr) {
            if (map.containsKey(target - num)) {
                return new int[]{map.get(num), map.get(target - num)};
            }
        }
        return null;
    }

    public static int getFibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

//find(n) {
//    if n in map:
//      return map[n]
//    if n == 0 or n = 1{
//        return 1
//    }
//    val = find(n-1) + find(n-2)
//    map[n] = val
//    return val
//}
//
//## bottom up
//## preferred
//find(n) {
//    dp = [0 for i in range(n+1)]
//    for i in range(2, n+1):
//    dp[i] = dp[i-1] + dp[i-2]
//    return dp[n]
//}
