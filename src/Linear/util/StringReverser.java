package Linear.util;

import java.util.Stack;

public class StringReverser {
    public static String reverseUsingStack(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        Stack<Character> stack = new Stack<Character>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static String reverseWithoutStack(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        int p1 = 0;
        int p2 = input.length() - 1;
        char[] chars = input.toCharArray();
        while (p1 < p2) {
            char temp = chars[p1];
            chars[p1] = chars[p2];
            chars[p2] = temp;
            p1++;
            p2--;
        }

        return new String(chars);
    }
}
