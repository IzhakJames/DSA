package Tree;

import java.util.Arrays;

public class MyMaxHeap {
    private int[] items;
    private int pointer;

    public MyMaxHeap(int size) {
        items = new int[size];
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public boolean isFull() {
        return pointer == items.length;
    }

    public void insert(int item) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }
        items[pointer++] = item;
        bubbleUp();

    }

    private void bubbleUp() {
        int currrentIndex = pointer - 1;
        int parent = (currrentIndex - 1) / 2;
        while (currrentIndex > 0 && items[currrentIndex] > items[parent]) {
            swap(currrentIndex, parent);
            currrentIndex = parent;
            parent = (currrentIndex - 1) / 2;
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int first = items[0];
        swap(0, pointer - 1);
        items[--pointer] = 0;
        bubbleDown();
        return first;

    }

    private void bubbleDown() {
        int currentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while (!(items[currentIndex] > items[leftChildIndex] && items[currentIndex] > items[rightChildIndex])) {
            int largerChildIndex = items[leftChildIndex] > items[rightChildIndex]
                    ? leftChildIndex
                    : rightChildIndex;

            swap(currentIndex, largerChildIndex);
            currentIndex = largerChildIndex;

            leftChildIndex = 2 * currentIndex + 1;
            rightChildIndex = 2 * currentIndex + 2;
            if (leftChildIndex >= pointer || rightChildIndex >= pointer) {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
