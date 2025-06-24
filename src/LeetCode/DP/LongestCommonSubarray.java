package LeetCode.DP;

import java.util.Arrays;

public class LongestCommonSubarray {
    public int[] longestCommonSubarray(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int maxLen = 0;
        int endIndex = 0;  // in A

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxLen = dp[i][j];
                        endIndex = i - 1;
                    }
                }
                System.out.println(Arrays.deepToString(dp));
            }
        }

        // Extract the subarray
        int[] result = new int[maxLen];
        for (int k = 0; k < maxLen; k++) {
            result[k] = A[endIndex - maxLen + 1 + k];
        }

        return result;
    }

}
