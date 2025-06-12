package LeetCode.arrays.twoPointers;

public class SquaresOfSortedArr {
    public int[] solutionQ977(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                left = i-1;
                right = i;
                break;
            }
            if (i == nums.length-1 && nums[i] < 0) {
                left = i;
                right = i+1;
                break;
            }
        }

        int curr = 0;
        while(left >= 0 && right < nums.length) {
            if (Math.abs(nums[left]) > nums[right]) {
                result[curr] = nums[right] * nums[right];
                right++;
            } else {
                result[curr] = nums[left] * nums[left];
                left--;
            }
            curr++;
        }

        if (left >= 0 && curr != nums.length) {
            for (int i = left; i >= 0; i--) {
                result[curr] = nums[i] * nums[i];
                curr++;
            }
        }

        if (right < nums.length && curr != nums.length) {
            for (int j = right; j < nums.length; j++) {
                result[curr] = nums[j] * nums[j];
                curr++;
            }
        }
        return result;
    }
}
