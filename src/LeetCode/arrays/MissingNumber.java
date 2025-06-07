package LeetCode.arrays;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int solutionQ268(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) {
            unique.add(num);
        }

        for (int i = 0; i < arr.length+1; i++) {
            if (!unique.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int solution2Q268(int[] arr) {
        int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }

        int fullSum = 0;
        for (int i = 0; i < arr.length+1; i++) {
            fullSum += i;
        }
        return fullSum - arrSum;
    }
}
