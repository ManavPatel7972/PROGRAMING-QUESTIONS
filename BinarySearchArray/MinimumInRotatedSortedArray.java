public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };

        System.out.println("Minimum = " + minimumEle(arr));
    }

    public static int minimumEle(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return arr[low];

    }
}