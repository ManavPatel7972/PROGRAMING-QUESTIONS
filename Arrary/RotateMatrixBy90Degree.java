public class RotateMatrixBy90Degree{
    public static void main(String[] args) {
          int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // int[][] rotated = rotateClockwise(mat);

        // for (int[] row : rotated) {
        //     for (int val : row) System.out.print(val + " ");
        //     System.out.println();
        // }

        rotateUsingTranspose(mat);

    }

    public static int[][] rotateClockwise(int[][] arr){
        int n = arr.length;
        int[][] rotate = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotate[j][n-i-1] = arr[i][j];
            }
        }

        return rotate;
    }


    public static void rotateUsingTranspose(int[][] arr){
        int n = arr.length;

        // transpose
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
            
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
            }
        }

        // reverse
        for (int i = 0; i < n; i++) {
            int l = 0, r = n-1;

            while (l<r) {
                int temp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = temp;
                l++;
                r--;    
            }
        }

        for (int[] i : arr) {
            for(int val : i) System.out.print(val + " ");
            System.out.println();
        }
        
    }

}