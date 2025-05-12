package Sorting;

public class QuickSort {
    public void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        // partition
        int boundary = partition(arr, start, end);

        // left sort
        sort(arr, start, boundary-1);

        // right sort
        sort(arr, boundary+1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int b = start - 1;
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, ++b);
            }
        }
        return b;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
