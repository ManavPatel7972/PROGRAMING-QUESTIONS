public class ReplaceO_sToX_s {
    public static void main(String[] args) {
        char[][] arr = { { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'O', 'X' },
                { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };

        // expected output:
        // [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
        ReplaceO_sToX_s obj = new ReplaceO_sToX_s();

        char[][] updated = obj.fill(arr);

        for (int i = 0; i < updated.length; i++) {
            for (int j = 0; j < updated[0].length; j++) {
                System.out.print(updated[i][j] + " ");
            }
            System.out.println();
        }

    }

    public char[][] fill(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] vis = new int[n][m];

        for (int j = 0; j < m; j++) {

            if (vis[0][j] == 0 && arr[0][j] == 'O') {
                dfs(0, j, arr, vis);
            }

            if (vis[n - 1][j] == 0 && arr[n - 1][j] == 'O') {
                dfs(n - 1, j, arr, vis);
            }
        }

        for (int i = 0; i < n; i++) {

            if (vis[i][0] == 0 && arr[i][0] == 'O') {
                dfs(i, 0, arr, vis);
            }

            if (vis[i][m - 1] == 0 && arr[i][m - 1] == 'O') {
                dfs(i, m - 1, arr, vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'O' && vis[i][j] == 0) {
                    arr[i][j] = 'X';
                }
            }
        }

        return arr;
    }

    public void dfs(int i, int j, char[][] arr, int[][] vis) {
        int n = arr.length;
        int m = arr[0].length;
        vis[i][j] = 1;

        // up
        if (i - 1 >= 0 && vis[i - 1][j] == 0 && arr[i - 1][j] == 'O') {

            dfs(i - 1, j, arr, vis);
        }

        // down
        if (i + 1 < n && vis[i + 1][j] == 0 && arr[i + 1][j] == 'O') {

            dfs(i + 1, j, arr, vis);
        }

        // left
        if (j - 1 >= 0 && vis[i][j - 1] == 0 && arr[i][j - 1] == 'O') {

            dfs(i, j - 1, arr, vis);
        }

        // right
        if (j + 1 < m && vis[i][j + 1] == 0 && arr[i][j + 1] == 'O') {

            dfs(i, j + 1, arr, vis);
        }

    }
}
