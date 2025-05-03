package Linear.util;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static Queue<Integer> reverse(Queue<Integer> q) {
        Stack<Integer> stack = new Stack<>();
        while (!q.isEmpty()) {
            stack.add(q.remove());
        }
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }
        return q;
    }
}
