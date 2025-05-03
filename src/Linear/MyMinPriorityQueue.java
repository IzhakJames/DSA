package Linear;

import java.util.Arrays;

// Tried an array implementation of priority queue but too inefficient
public class MyMinPriorityQueue {
    int[] items;
    int pointer = 0;
    int size = 0;

    public MyMinPriorityQueue(int size) {
        this.items = new int[size];
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        int i;
        for (i = pointer - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        items[i + 1] = item;
        pointer++;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
