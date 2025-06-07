package LeetCode.arrays;

import java.util.*;

public class DisappearedNumsInArray {
    public Integer[] solutionQ448(int[] arr) {
        int n = arr.length;
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) {
            unique.add(num);
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (!unique.contains(i)) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[0]);
    }

    public List<Integer> solutionQ448_Optimal(int[] nums) {
        int n = nums.length;
        System.out.println(Arrays.toString(nums));

        // Phase 1: Mark visited numbers using the array itself
        // Iterate through each number. For each number 'val', go to the index
        // corresponding to its value (abs(val) - 1) and mark that number negative.
        // If it's already negative, it means we've seen this value before.
        for (int i = 0; i < n; i++) {
            int indexToMark = Math.abs(nums[i]) - 1; // Get the correct 0-based index
            System.out.println(indexToMark);
            if (nums[indexToMark] > 0) { // If the number at this index is positive, mark it negative
                nums[indexToMark] *= -1;
            }
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(nums));

        // Phase 2: Collect the missing numbers
        // Iterate through the array. If a number is positive, it means its corresponding
        // value was never encountered in the original array.
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // Add i+1 because indices are 0-based, values are 1-based
            }
        }

        return result; // LeetCode Q448 asks for List<Integer> as output
    }
}
