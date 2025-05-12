package Sorting;

public class BubbleSort {
    public void sort(int[] array) {
        int n = array.length;
        boolean isSorted = false;
        for (int i = 0; i < n-1; i++) {
            isSorted = true;
            for (int j= 0; j < n - i - 1; j ++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
