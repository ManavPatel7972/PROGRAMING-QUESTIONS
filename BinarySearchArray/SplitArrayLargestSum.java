import java.util.Arrays;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] a = { 10, 20, 30, 40 };
        int k = 2;
        int ans = largestSubArraySumMinimizedOptimal(a, k);
        System.out.println("The answer is: " + ans);
    }

    public static int largestSubArraySumMinimized(int[] arr, int k) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        for (int i = low; i <= high; i++) {
            if (countPartition(arr, i) == k) {
                return i;
            }
        }

        return low;
    }

    public static int largestSubArraySumMinimizedOptimal(int[] arr, int k) {
        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = (low + high) / 2;
            int partitions = countPartition(arr, mid);

            if (partitions > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countPartition(int[] arr, int k) {
        int partitions = 1;
        long subArraySum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (subArraySum + arr[i] <= k) {
                subArraySum += arr[i];
            } else {
                partitions++;
                subArraySum = arr[i];
            }
        }

        return partitions;
    }
}
