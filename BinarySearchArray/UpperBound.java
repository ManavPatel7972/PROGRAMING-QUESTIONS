public class UpperBound {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,8,8,11,13};
        int x = 7;
        int idx = upperBound(arr, x);
        System.out.println("UpperBound = " + idx);
    }

    public static int upperBound(int[] arr, int x) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;

            }

        }

        return ans;
    }
}
