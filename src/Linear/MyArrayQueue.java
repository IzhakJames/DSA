package Linear;

import java.util.Arrays;

/*
 * Queue Operations Complexity:
 *
 * enqueue()  -> O(1)      // Add an element to the rear (offer/add)
 * dequeue()  -> O(1)      // Remove and return the front element (poll/remove)
 * peek()     -> O(1)      // Return the front element without removing
 * isEmpty()  -> O(1)      // Check if the queue is empty
 * size()     -> O(1)      // Return number of elements in the queue
 * contains() -> O(n)      // Linear search from front to rear
 * clear()    -> O(n)      // Remove all elements (clears underlying array/linked nodes)
 *
 */

// This is a circular array
public class MyArrayQueue {
    int[] array;
    int size;
    int front;
    int rear;

    public MyArrayQueue(int size) {
        this.array = new int[size];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public void enqueue(int value) {
//        NOTE: use the code below for dynamic sized queues
//        if (size == array.length) {
//            int[] newArray = new int[array.length * 2];
//            System.arraycopy(array, 0, newArray, 0, array.length);
//            array = newArray;
//        }
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        array[rear] = value;
        rear = (rear + 1) % array.length;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
