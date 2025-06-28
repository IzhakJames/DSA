package LeetCode.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LexicographicalNumbers {
    public List<Integer> solutionQ386(int n) {
        List<Integer> result = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            result.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                curr += 1;
            }
        }
        return result;
    }
}
