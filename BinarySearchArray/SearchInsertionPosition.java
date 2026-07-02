public class SearchInsertionPosition {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7 };
        int x = 2;

        int index = searchInsert(arr, x);

        System.out.println("The index is: " + index);
    }

    public static int searchInsert(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;

        int ans = arr.length;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid;
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
