package LeetCode.arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean solutionQ217(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        for (int num : arr) {
            if (unique.contains(num)) {
                return true;
            }
            unique.add(num);
        }
        return false;
    }
}
