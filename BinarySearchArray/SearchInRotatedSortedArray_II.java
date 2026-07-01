public class SearchInRotatedSortedArray_II {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        System.out.println("Is Present = " + sortedArrayOptimal(arr, target));
    }

    public static boolean sortedArrayOptimal(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return true;

            if (arr[low] == arr[mid] && arr[high] == arr[mid]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;

                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
