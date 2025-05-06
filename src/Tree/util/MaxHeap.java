package Tree.util;

public class MaxHeap {

    public static void heapify(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int i) {
        int largest = i;
        int leftChildIndex = 2 * i + 1;
        if (leftChildIndex < arr.length && arr[leftChildIndex] > arr[largest]) {
            largest = leftChildIndex;
        }
        int rightChildIndex = 2 * i + 2;
        if (rightChildIndex < arr.length && arr[rightChildIndex] > arr[largest]) {
            largest = rightChildIndex;
        }
        if (largest == i) {
            return;
        }
        swap(arr, i, largest);
        heapify(arr, largest);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
