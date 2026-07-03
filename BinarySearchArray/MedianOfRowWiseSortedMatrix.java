public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5 },
                { 2, 6, 9 },
                { 3, 6, 9 }
        };
        System.out.println("Median: " + findMedian(matrix));
    }

    public static int findMedian(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;

        int low = arr[0][0];
        int high = arr[0][col - 1];

        for (int i = 1; i < row; i++) {
            low = Math.min(low, arr[i][0]);
            high = Math.max(high, arr[i][col - 1]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < row; i++) {
                cnt += countLessEqual(arr[i], mid);
            }

            if (cnt < (row * col + 1) / 2) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static int countLessEqual(int[] arr, int mid) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int m = (low + high) / 2;

            if (arr[m] <= mid)
                low = m + 1;
            else
                high = m;
        }
        return low;
    }
}
