package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };

        System.out.println("Before:\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        insertionSort(arr);

        System.out.println("After\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;

            while (j > 0 && arr[j - 1] > arr[j]) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }

        }
    }
}
