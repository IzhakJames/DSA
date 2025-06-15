package LeetCode.arrays.twoPointers;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> solutionQ15(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int left = i+1;
            int right = nums.length-1;
            int num1 = nums[i];
            while(left < right) {
                int diff = num1 + nums[left] + nums[right];
                if (diff < 0)
                    left++;
                else if (diff > 0)
                    right++;
                else {
                    result.add(Arrays.asList(num1,nums[left],nums[right]));
                    left++;
                    while(left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                }

            }

        }
        return result;
    }
}
