package Linear;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * Stack Operations Complexity:
 *
 * push()     -> O(1)      // Add an element to the top
 * pop()      -> O(1)      // Remove and return the top element
 * peek()     -> O(1)      // Return the top element without removing
 * isEmpty()  -> O(1)      // Check if the stack is empty
 * size()     -> O(1)      // Return number of elements in the stack
 * contains() -> O(n)      // Linear search from top to bottom
 * search()   -> O(n)      // Returns 1-based position from the top (like java.util.Stack)
 * clear()    -> O(n)      // Removes all elements (reference nullification or memory cleanup)
 */
public class MyStack {
    private int[] array;
    private int position = 0;

    MyStack(int size) {
        array = new int[size];
    }

    public boolean isEmpty() {
        return position == 0;
    }

    public int size() {
        return position;
    }

    public void push(int data) {
        if (position == array.length) {
            int[] newArray = new int[position * 2];
            // Using system.arraycopy method instead of doing manual copy
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[position++] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Stack is empty"
            );
        }
        return array[--position];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[position - 1];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, position));
    }


}
