package LeetCode.arrays.twoPointers;

public class BestTimeToBuyStock {
    public int solutionQ121(int[] prices) {
        int p1 = 0;
        int p2 = 1;
        int result = 0;
        while(p2 < prices.length) {
            if (prices[p2] > prices[p1]) {
                result = Math.max(result, prices[p2] - prices[p1]);
            } else {
                p1 = p2;
            }
            p2++;
        }
        return result;
    }
}
