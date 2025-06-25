package LeetCode.strings;

import java.util.*;

public class ValidParentheses {
    public boolean solutionQ20(String s) {
        char[] closing = new char[]{')','}',']'};
        char[] opening = new char[]{'(','{','['};
        Map<Character, Character> closingMap = new HashMap<>();
        Set<Character> openingSet = new HashSet<>();
        for (int i = 0; i < closing.length; i++) {
            closingMap.put(closing[i], opening[i]);
        }
        for (char c : opening) {
            openingSet.add(c);
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (openingSet.contains(c)) {
                stack.push(c);
            } else {
                if (stack.empty() || stack.peek() != closingMap.get(c)) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
