package LeetCode.arrays.slidingWindow;

public class MinSizeSubArrSum {
    public int solutionQ209(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < nums.length) {
            currSum += nums[right];
            if (currSum >= target) {
                while(currSum >= target) {
                    min = Math.min(min, right-left+1);
                    currSum -= nums[left];
                    left++;
                }
            }
            right++;
        }
        if (min > nums.length) {
            return 0;
        }
        return min;
    }
}
