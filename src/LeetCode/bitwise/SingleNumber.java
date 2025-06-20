package LeetCode.bitwise;

public class SingleNumber {

    public int solutionQ136(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
