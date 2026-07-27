package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Before:\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("After\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> li = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                li.add(arr[left++]);
            else
                li.add(arr[right++]);
        }

        while (left <= mid) {
            li.add(arr[left++]);
        }

        while (right <= high) {
            li.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = li.get(i - low);
        }
    }
}
