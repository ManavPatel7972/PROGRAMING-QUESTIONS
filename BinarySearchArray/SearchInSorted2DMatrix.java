public class SearchInSorted2DMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };

        if (searchArr(arr, 8))
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static boolean searchArr(int[][] arr, int target) {

        int n = arr.length;
 
        int m = arr[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int row = mid / m;
            int col = mid % m;

            if (arr[row][col] == target)
                return true;

            else if (arr[row][col] < target)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return false;
    }

    public boolean searchMatrixBetter(int[][] matrix, int target) {
        int n = matrix.length;

        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][m - 1]) {
                return binarySearch(matrix[i], target);
            }
        }

        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int n = nums.length;

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target)
                return true;

            else if (target > nums[mid])
                low = mid + 1;

            else
                high = mid - 1;
        }

        return false;
    }
}