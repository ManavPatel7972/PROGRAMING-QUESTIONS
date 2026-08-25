import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class NumberOfEnclaves {

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 1, 0 },
                { 0, 0, 0, 0 },
        };

        NumberOfEnclaves obj = new NumberOfEnclaves();

        System.out.println("NumberOfEnclaves = " + obj.numEnclaves(arr));
    }

    public int numEnclaves(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] vis = new int[n][m];

        for (int j = 0; j < m; j++) {

            if (arr[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, arr, vis);
            }

            if (arr[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                dfs(n - 1, j, arr, vis);
            }
        }

        for (int i = 0; i < n; i++) {

            if (arr[i][0] == 1 && vis[i][0] == 0) {
                dfs(i, 0, arr, vis);
            }

            if (arr[i][m - 1] == 1 && vis[i][m - 1] == 0) {
                dfs(i, m - 1, arr, vis);
            }
        }

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != vis[i][j]) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int i, int j, int[][] arr, int[][] vis) {
        int n = arr.length;
        int m = arr[0].length;
        vis[i][j] = 1;

        if (i - 1 >= 0 && arr[i - 1][j] == 1 && vis[i - 1][j] == 0) {
            dfs(i - 1, j, arr, vis);
        }

        if (i + 1 < n && arr[i + 1][j] == 1 && vis[i + 1][j] == 0) {
            dfs(i + 1, j, arr, vis);
        }

        if (j - 1 >= 0 && arr[i][j - 1] == 1 && vis[i][j - 1] == 0) {
            dfs(i, j - 1, arr, vis);
        }

        if (j + 1 < m && arr[i][j + 1] == 1 && vis[i][j + 1] == 0) {
            dfs(i, j + 1, arr, vis);
        }
    }

    public int numEnclavesBFS(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    q.add(new Pair(i, j));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = { -1, 0, 1, 0 };
        int[] delCol = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int r = q.peek().r;
            int c = q.peek().c;

            q.remove();

            for (int k = 0; k < 4; k++) {

                int nr = r + delRow[k];
                int nc = c + delCol[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && arr[nr][nc] == 1 && vis[nr][nc] == 0) {
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

}