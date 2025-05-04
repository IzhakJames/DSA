
import Linear.MyHashMap;
import Linear.util.CharacterFinder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] keys = {1, 7, 5, 9, 2, 12, 3};
        int result = countPairsWithDiff(keys, 2);
        System.out.println(result);

        int[] input = {2, 7, 11, 15};
        int[] result2 =  twoSum(input, 9);
        System.out.println(Arrays.toString(result2));

    }

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
}