public class SearchInsertion {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 7, 9, 10, 13, 17, 20 };
        int target = 14;

        System.out.println("Index = " + search(arr, target));
    }

    public static int search(int[] arr, int target) {
        if (arr.length == 0)
            return 0;

        int ans = arr.length;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
