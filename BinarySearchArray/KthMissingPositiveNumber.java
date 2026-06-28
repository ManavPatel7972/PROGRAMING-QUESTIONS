public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = { 4, 7, 9, 10 };
        int k = 1;

        System.out.println("Missing = " + missingKOptimal(arr, k));

    }

    public static int missingKBrute(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }

        return k;
    }

    public static int missingKOptimal(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k)
                low = mid + 1;
            else
                high = mid - 1;

        }

        // return low + k;
        return high + 1 + k;
    }

}
