import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIsland {
    public static void main(String[] args) {

    }

    public static int numIslandsBFS(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }

    public static void bfs(int i, int j, char[][] grid, int[][] vis) {

        Queue<Pair> q = new LinkedList<>();

        vis[i][j] = 1;
        q.add(new Pair(i, j));

        int n = grid.length;
        int m = grid[0].length;

        int[] dRow = { -1, 1, 0, 0 };
        int[] dCol = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int k = 0; k < 4; k++) {
                int nRow = row + dRow[k];
                int nCol = col + dCol[k];

                if (nRow >= 0 && nRow < m &&
                        nCol >= 0 && nCol < n &&
                        vis[nRow][nCol] == 0 &&
                        grid[nRow][nCol] == '1') {

                    vis[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }

    public static int numIslandsDFS(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, grid, vis);
                }
            }
        }

        return cnt;
    }

    public static void dfs(int i, int j, char[][] grid, int[][] vis) {
        vis[i][j] = 1;
        int n = grid.length;
        int m = grid[0].length;

        if (i + 1 < n && vis[i + 1][j] == 0 && grid[i + 1][j] == '1') {
            dfs(i + 1, j, grid, vis);
        }

        if (i - 1 >= 0 && vis[i - 1][j] == 0 && grid[i - 1][j] == '1') {
            dfs(i - 1, j, grid, vis);
        }

        if (j + 1 < m && vis[i][j + 1] == 0 && grid[i][j + 1] == '1') {
            dfs(i, j + 1, grid, vis);
        }

        if (j - 1 >= 0 && vis[i][j - 1] == 0 && grid[i][j - 1] == '1') {
            dfs(i, j - 1, grid, vis);
        }
    }
}
