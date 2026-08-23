import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row, col, pRow, pCol;

    Pair(int r, int c, int pr, int pc) {
        row = r;
        col = c;
        pRow = pr;
        pCol = pc;
    }
}

public class DetectCycleIn2DGrid {

    int[] dr = { -1, 0, 1, 0 };
    int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) {

    }

    public boolean containsCycle(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == false) {
                    if (bfs(i, j, arr, vis))
                        return true;
                }
            }
        }
        return false;
    }

    public boolean bfs(int i, int j, char[][] arr, boolean[][] vis) {
        int n = arr.length;
        int m = arr[0].length;
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j, -1, -1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();

            int r = curr.row;
            int c = curr.col;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                // Index bound
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                // Different character
                if (arr[nr][nc] != arr[r][c]) {
                    continue;
                }

                // Parent cell -> ignore
                if (nr == curr.pRow && nc == curr.pCol) {
                    continue;
                }

                // Already visited and not parent -> cycle
                if (vis[nr][nc]) {
                    return true;
                }

                vis[nr][nc] = true;

                q.add(new Pair(nr, nc, r, c));

            }
        }

        return false;
    }
}
