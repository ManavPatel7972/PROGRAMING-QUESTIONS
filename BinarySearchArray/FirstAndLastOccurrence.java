public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] res = firstAndLast(arr, target);
        System.out.println("{" + res[0] + ", " + res[1] + "}");
    }

    

    public static int[] firstAndLast(int[] arr, int target) {
        int lb = lowerBound(arr, target);
        int up = upperBound(arr, target);

        if(arr[lb] != target || lb == arr.length) return new int[]{-1,-1};

        return new int[]{lb,up-1};
    }

    public static int lowerBound(int[] arr, int x) {
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;

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
