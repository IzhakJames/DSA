package LeetCode.arrays.twoPointers;

import java.util.Arrays;

public class NumSubSeqOfGivenSum {
    public int solutionQ1498(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = len-1;
        int MOD = (int) Math.pow(10,9) + 7;

        int[] powers = new int[len];
        powers[0] = 1;
        for (int i = 1; i < len; i++) {
            powers[i] = (powers[i-1] * 2) % MOD;
        }

        int result = 0;
        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                int count = powers[r-l];
                result = (count+result) % MOD;
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
