package Recursion;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };

        System.out.println("Before : ");
        for (int i : arr) {
            System.out.print(i);
        }

        System.out.println();
        revArrayUsingSinglePointer(arr, 0);
        System.out.println();

        System.out.println("After : ");
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void revArray(int[] arr, int l, int r) {
        if (l >= r)
            return;

        // swap
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        revArray(arr, l + 1, r - 1);

    }

    public static void revArrayUsingSinglePointer(int[] arr, int i) {
        if (i >= arr.length / 2)
            return;

        // swap
        int temp = arr[i];
        arr[i] = arr[arr.length - i - 1];
        arr[arr.length - i - 1] = temp;

        revArrayUsingSinglePointer(arr, i + 1);

    }

    
}
