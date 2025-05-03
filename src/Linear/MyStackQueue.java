package Linear;

import java.util.Stack;

/*
Implementation of a queue using two stacks
 */
public class MyStackQueue {
    Stack<Integer> enqueue = new Stack<>();
    Stack<Integer> dequeue = new Stack<>();

    // O(1)
    public void enqueue(int value) {
        enqueue.push(value);
    }

    // O(n)
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else if (dequeue.isEmpty()) {
            transfer();
        }
        return dequeue.pop();
    }

    // O(n)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else if (dequeue.isEmpty()) {
            transfer();
        }
        return dequeue.peek();
    }

    public boolean isEmpty() {
        return enqueue.isEmpty() && dequeue.isEmpty();
    }

    private void transfer() {
        while (!enqueue.isEmpty()) {
            dequeue.push(enqueue.pop());
        }
    }
}
