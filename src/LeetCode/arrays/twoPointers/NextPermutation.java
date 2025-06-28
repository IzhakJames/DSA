package LeetCode.arrays.twoPointers;

import java.util.Arrays;

public class NextPermutation {
    public void solutionQ31(int[] nums) {
        int nextSmallest = nums.length - 2;
        while (nextSmallest >= 0 && nums[nextSmallest] >= nums[nextSmallest+1]) {
            nextSmallest--;
        }

        if (nextSmallest < 0) {
            reverse(nums, 0, nums.length-1);
        } else {
            int smallestOnRightIndex = nextSmallest+1;
            int currSmallest = nums[nextSmallest + 1];
            for (int i = nextSmallest + 1; i < nums.length; i++ ) {
                if (nums[nextSmallest] < nums[i] && nums[i] < currSmallest) {
                    currSmallest = nums[i];
                    smallestOnRightIndex = i;
                }
            }
            swap(nums, nextSmallest, smallestOnRightIndex);
            reverse(nums, nextSmallest+1, nums.length-1) ;
        }
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] arr, int start, int end) {
        int l = start;
        int r = end;
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

}
