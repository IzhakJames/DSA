package Searching;

public class Search {
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearchIter(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRec(int[] arr, int target) {
        return binarySearchRec(arr, target, 0, arr.length - 1);
    }

    private int binarySearchRec(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRec(arr, target, left, mid-1);
        } else {
            return binarySearchRec(arr, target, mid+1, right);
        }
    }

    public int ternarySearch(int[] arr, int target) {
        return ternarySearch(arr, target, 0, arr.length - 1);
    }

    private int ternarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int partition = (right - left) / 3;
        int mid1 = left+partition;
        int mid2 = right-partition;

        if (arr[mid1] == target) {
            return mid1;
        } else if (arr[mid2] == target) {
            return mid2;
        } else if (arr[mid1] > target) { //first partition
            return ternarySearch(arr, target, left, mid1-1);
        } else if (arr[mid2] < target) { //last partition
            return ternarySearch(arr, target, mid2+1, right);
        } else { //middle partition
            return ternarySearch(arr, target, mid1+1, mid2-1);
        }
    }

    // searching by blocks, blockSize = square root of n
    public int jumpSearch(int[] arr, int target) {
        int blockSize = (int) Math.sqrt(arr.length);
        System.out.println("Using block size : " + blockSize);
        int start = 0;
        int end = blockSize;
        while (end < arr.length) {
            if (arr[end] == target) {
                return end;
            } else if (arr[end] > target) {
                return binarySearchRec(arr, target, start,end-1);
            } else {
                start = end;
                end += blockSize;
            }
        }
        return binarySearchRec(arr, target, start, arr.length-1);
    }

    public int exponentialSearch(int[] arr, int target) {
        int bound = 1;
        while (bound < arr.length && arr[bound] < target) {
            bound *= 2;
        }
        int left = bound / 2;
        int right = Math.min(bound, arr.length - 1); // same as : bound > arr.length ? arr.length-1 : bound;
        return binarySearchRec(arr, target, left, right);
    }
}
