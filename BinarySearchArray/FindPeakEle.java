public class FindPeakEle {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
        System.out.println("ELE = " + findPeakOptimal(arr));
    }

    public static int findPeakBrute(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i] > arr[i - 1]) && (i == n - 1 || arr[i] > arr[i + 1])) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int findPeakOptimal(int[] arr) {
        int n = arr.length;

        if (n == 1)
            return 0;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == n - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            if (mid < n - 1 && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
