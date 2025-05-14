

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static StringManipulations.StringUtil.lengthOfLongestSubstring;

public class Main {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3 ("abc")
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1 ("b")
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3 ("wke")
        System.out.println(lengthOfLongestSubstring(""));         // Output: 0
    }


}