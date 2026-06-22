public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 12;

        // System.out.println("Find At Index = " + binarySearch(arr, target));
        System.out.println("Find At Index = " + binarySearchRecursive(arr, 0, arr.length - 1, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (target > arr[mid])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int low, int high, int target) {

        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (target == arr[mid])
            return mid;

        else if (target > arr[mid])
            return binarySearchRecursive(arr, mid + 1, high, target);

        return binarySearchRecursive(arr, low, mid - 1, target);

    }

}
