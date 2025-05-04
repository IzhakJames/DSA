
import Linear.MyHashMap;
import Linear.MyLBHashMap;
import Linear.util.CharacterFinder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyLBHashMap map = new MyLBHashMap(8);
        map.put(0,"First");
        map.put(1,"Second");
        map.put(2,"Third");
        map.put(2,"NEW");
        map.put(16,"Fourth");
        System.out.println(map.get(3));
        System.out.println(map.get(16));
        System.out.println(map.get(2));
        map.put(3,"Fifth");
        map.put(0, "Updated 0");
        map.put(5, "Updated 1");
        map.put(6, "Updated 2");
        map.put(7, "Updated 3");
        System.out.println(map.get(0));
        System.out.println(map.get(3));
        System.out.println(map.get(6));
        System.out.println(map.get(8));
        System.out.println(map.remove(7));
        System.out.println(map.remove(7));




//        // For Testing code below
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] keys = {1, 7, 5, 9, 2, 12, 3};
//        int result = countPairsWithDiff(keys, 2);
//        System.out.println(result);
//
//        int[] input = {2, 7, 11, 15};
//        int[] result2 =  twoSum(input, 9);
//        System.out.println(Arrays.toString(result2));

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