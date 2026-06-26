import java.util.Arrays;

public class FindSmallestDivisorThreshold {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int limit = 8;

        System.out.println("The minimum divisor is: " + smallestDivisorOptimal(arr, limit));
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length;

        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        for (int i = 1; i <= max; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += (int) Math.ceil((double) arr[j] / i);
            }

            if (sum <= limit) {
                return i;
            }
        }

        return -1;

    }

    public static int smallestDivisorOptimal(int[] arr, int limit) {

        int low = 1;
        int high = Arrays.stream(arr).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumByD(arr, mid) <= limit) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    public static int sumByD(int[] arr, int div) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.ceil((double) i / div);
        }

        return sum;

    }
}
