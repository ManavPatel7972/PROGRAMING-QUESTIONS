public class MinimumDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int m = 2;
        int k = 3;

        System.out.println("Minimum Number Of = " + miniOptimal(arr, m, k));

    }

    public static int miniBrute(int[] arr, int m, int k) {

        long totalFlowers = (long) m * k;
        if (totalFlowers > arr.length)
            return -1;

        int[] temp = miniMaxi(arr);

        for (int i = temp[0]; i <= temp[1]; i++) {
            if (isPossible(arr, i, m, k))
                return i;
        }

        return -1;

    }

    public static boolean isPossible(int[] arr, int day, int m, int k) {
        int cnt = 0;
        int booke = 0;

        for (int i : arr) {
            if (i <= day) {
                cnt++;

                if (cnt == k) {
                    booke++;
                    cnt = 0;
                }

            } else {
                cnt = 0;
            }
        }

        return booke >= m;
    }

    public static int[] miniMaxi(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return new int[] { min, max };
    }

    public static int miniOptimal(int[] arr, int m, int k) {

        long totalFlowers = (long) m * k;
        if (totalFlowers > arr.length)
            return -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        int low = min, high = max, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;

    }
}
