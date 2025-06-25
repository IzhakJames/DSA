package LeetCode.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValidParenthesis {
    public String solutionQ1249(String s) {
        int openIndex = s.length();
        Stack<Integer> openIndexes = new Stack<>();
        Set<Integer> indexToRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                if (openIndexes.isEmpty() || i < openIndex) {
                    indexToRemove.add(i);
                } else {
                    openIndex = openIndexes.pop();
                }
            } else if (ch == '(') {
                openIndex = i;
                openIndexes.push(i);
            }
        }
        while (!openIndexes.isEmpty()) {
            indexToRemove.add(openIndexes.pop());
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
