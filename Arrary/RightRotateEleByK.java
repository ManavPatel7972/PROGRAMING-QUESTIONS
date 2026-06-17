import java.util.Arrays;

public class RightRotateEleByK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        rotateRight(arr, k);

        System.out.println("Array after right rotation: "
                           + Arrays.toString(arr));
    }

    public static void rotateRight(int[] arr, int k) {
        k = k % arr.length;

        int[] temp = new int[k];

        // Store last k elements
        for (int i = 0; i < k; i++) {
            temp[i] = arr[arr.length - k + i];
        }

        // Shift remaining elements to right
        for (int i = arr.length - k - 1; i >= 0; i--) {
            arr[i + k] = arr[i];
        }

        // Copy temp elements at beginning
        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
        }
    }
}