import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 1, 3, 6 };
        int cows = 2;

        System.out.println("Maxi = " + aggressiveCowsOptimal(arr, cows));
    }

    public static int aggressiveCows(int[] arr, int cows) {

        Arrays.sort(arr);

        int maxDist = arr[arr.length - 1] - arr[0];

        int ans = 0;

        for (int i = 1; i <= maxDist; i++) {

            if (canPlace(arr, cows, i)) {
                ans = i;
            }
        }

        return ans;
    }

    public static int aggressiveCowsOptimal(int[] arr, int cows) {

        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(arr, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }

    public static boolean canPlace(int[] arr, int cows, int dist) {
        int count = 1;
        int lastCowPos = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - lastCowPos >= dist) {
                count++;
                lastCowPos = arr[i];
            }

            if (count >= cows)
                return true;
        }

        return false;
    }
}
