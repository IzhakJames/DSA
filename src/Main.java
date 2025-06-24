
import LeetCode.DP.ClimbingStairs;
import LeetCode.DP.CoinChange;
import LeetCode.DP.LongestCommonSubarray;
import LeetCode.bitwise.SingleNumber;
import Linear.util.PairCounters;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        LongestCommonSubarray solution = new LongestCommonSubarray();
        int[] A = {1, 2, 2, 5, 6, 8};
        int[] B = {2, 2, 3, 5, 6, 8, 9};

        System.out.println(Arrays.toString(solution.longestCommonSubarray(A, B)));



    }

}