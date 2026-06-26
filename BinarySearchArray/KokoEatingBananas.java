
public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] arr = { 7, 15, 6, 3 };
        int h = 8;
        System.out.println("Minimum Banana = " + miniBananaOptimal(arr, h));
    }

    public static int miniBananaBrute(int[] arr, int h) {

        int maxVal = maxVal(arr);

        for (int i = 1; i <= maxVal; i++) {
            int requiredTime = time(arr, i);

            if (requiredTime <= h) {
                return i;
            }
        }
        return maxVal;
    }

    public static int time(int[] arr, int hour) {
        int totalTime = 0;
        for (int i : arr) {
            totalTime += (int) Math.ceil((double) i / hour);
        }

        return totalTime;
    }

    public static int maxVal(int[] arr) {
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static int miniBananaOptimal(int[] arr, int h) {

        int low = 1;
        int high = maxVal(arr);
        int ans = maxVal(arr);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int requiredTime = time(arr, mid);
            if (requiredTime <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}