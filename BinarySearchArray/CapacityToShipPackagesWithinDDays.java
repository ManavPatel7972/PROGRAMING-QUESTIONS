import java.util.Arrays;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int day = 5;
        System.out.println("Mini Load = " + miniLoadOptimal(arr, day));
    }

    public static int miniLoadOptimal(int[] arr, int day) {

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int needDay = daysNeeded(arr, mid);

            if (needDay <= day) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }

    public static int daysNeeded(int[] arr, int capacity) {
        int days = 1;
        int currentLoad = 0;

        for (int w : arr) {

            if (currentLoad + w > capacity) {
                days++;
                currentLoad = w;
            } else {
                currentLoad += w;
            }
        }
        return days;
    }

}
