package LeetCode.arrays.twoPointers;

public class LongestMountainInArray {
    public int solutionQ845(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            int left = i;
            int right = i;
            while (left > 0) {
                if (arr[left-1] >= arr[left])
                    break;
                left--;
            }
            while (right < arr.length-1) {
                if (arr[right+1] >= arr[right])
                    break;
                right++;
            }
            if (right == i || left == i) {
                continue;
            }
            result = Math.max(result, right-left+1);
        }
        return result;
    }

    //FASTER
    public int solution2Q845(int[] arr) {
        int result = 0;
        for (int i = 1; i < arr.length-1; i++) {
            if (arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                int left = i;
                int right = i;
                while (left > 0 && arr[left] > arr[left-1])
                    left--;

                while (right < arr.length-1 && arr[right] > arr[right+1])
                    right++;

                result = Math.max(result, right-left+1);
            }
        }
        return result;
    }
}
