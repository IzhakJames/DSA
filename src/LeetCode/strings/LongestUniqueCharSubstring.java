package LeetCode.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueCharSubstring {
    public int solutionQ3(String s) {
        Set<Character> unique = new HashSet<>();
        int left = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            char curr = s.charAt(right);
            while(unique.contains(curr)) {
                unique.remove(s.charAt(left));
                left++;
            }
            unique.add(curr);
            result = Math.max(result, right-left+1);
        }
        return result;
    }
}
