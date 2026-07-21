package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 13, 46, 24, 52, 20, 9 };

        System.out.println("Before:\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }

        bubbleSort(arr);

        System.out.println("After\n");

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
