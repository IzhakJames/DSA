package LeetCode.arrays.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {
    public boolean solutionQ219(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i]))
                return true;
            window.add(nums[i]);
            if (window.size() > k) {
                window.remove(nums[i-k]);
            }
        }
        return false;
    }
}
