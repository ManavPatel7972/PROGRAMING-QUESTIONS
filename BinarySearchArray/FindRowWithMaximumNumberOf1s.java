public class FindRowWithMaximumNumberOf1s {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        int n = 3, m = 3;
        System.out.println("The row with maximum no. of 1's is: " + rowWithMax1sOptimal(matrix, n, m));

    }

    public static int rowWithMax1s(int[][] arr, int n, int m) {
        int cntMax = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            for (int j = 0; j < m; j++) {
                cnt += arr[i][j];
            }

            if (cnt > cntMax) {
                cntMax = cnt;
                idx = i;
            }
        }

        return idx;
    }

    public static int rowWithMax1sOptimal(int[][] arr, int n, int m) {
        int cntMax = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            int cnt = 0;

            // Count of 1s = total columns - index of first 1 (lower bound)
            cnt = m - lowerBound(arr[i], m, 1);

            if (cnt > cntMax) {
                cntMax = cnt;
                idx = i;
            }
        }

        return idx;
    }

    public static int lowerBound(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;

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
