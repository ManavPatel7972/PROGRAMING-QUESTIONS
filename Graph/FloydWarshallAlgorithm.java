public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 4, 5, 5, 7 },
                { 3, 0, 1, 4, 6 },
                { 2, 6, 0, 3, 5 },
                { 3, 7, 1, 0, 2 },
                { 1, 5, 5, 4, 0 },
        };

        FloydWarshallAlgorithm obj = new FloydWarshallAlgorithm();
        obj.floyd_warshall(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void floyd_warshall(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }

                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }
}
