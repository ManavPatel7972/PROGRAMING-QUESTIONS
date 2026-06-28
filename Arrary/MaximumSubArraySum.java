
public class MaximumSubArraySum {
    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int maxSum = maxSubArray(arr);
        System.out.println("The maximum subArray sum is: " + maxSum);
    }

    // time complexity: O(n^3).
    // space complexity: O(1).
    public static int maxSubArray(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    // time complexity: O(n^2).
    // space complexity: O(1).
    public static int maxSubArray2(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }

        }

        return max;
    }

    // time complexity: O(n).
    // space complexity: O(1).
    public static int maxSubArray3(int[] arr) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = -1;

        int ansEnd = -1;
        int ansStart = -1;

        for (int i = 0; i < arr.length; i++) {

            if (sum == 0)
                start = i;

            sum += arr[i];

            if (sum > max) {
                max = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) {
                sum = 0;
            }

        }

        System.out.print("The subArray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");

        return max;
    }
}
