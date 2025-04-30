package Linear.util;

import java.util.*;

public class ExpressionBalancer {
    private static final List<Character> openBrackets  = Arrays.asList('[', '(', '<', '{');
    private static final List<Character> closeBrackets = Arrays.asList(']', ')', '>', '}');


    public static boolean isBalance(String input) {

        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        for (int i = 0; i < closeBrackets.size(); i++) {
            bracketMap.put(closeBrackets.get(i), openBrackets.get(i));
        }
        Stack<Character> stack = new Stack<Character>();
        for (char item : input.toCharArray()) {
            if (openBrackets.contains(item)) {
                stack.push(item);
            } else if (bracketMap.containsKey(item)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == bracketMap.get(item)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
