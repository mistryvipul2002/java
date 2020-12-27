package com.programming.exercises.practice.arrays;

public class MergeSort {

    public static void main(String[] args) {
        final int[] arr = Util.randomArray(10);
        Util.printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        Util.printArray(arr);
    }

    private static void mergeSort(int[] arr, int from, int to) {
        if (to == from + 1) {
            if (arr[from] > arr[to]) {
                swapContents(arr, from, to);
                return;
            }
        }

        if (to > from) {
            int mid = (from + to) / 2;
            mergeSort(arr, from, mid);
            mergeSort(arr, mid + 1, to);
            merge(arr, from, mid, to);
        }
    }

    /**
     * Copied from https://www.geeksforgeeks.org/merge-sort/
     */
    private static void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private static void swapContents(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

}
