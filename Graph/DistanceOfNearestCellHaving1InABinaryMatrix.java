import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int f, s, d;

    Pair(int f, int s, int d) {
        this.f = f;
        this.s = s;
        this.d = d;
    }
}

public class DistanceOfNearestCellHaving1InABinaryMatrix {

    public static void main(String[] args) {

    }

    public static int[][] nearest(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().f;
            int col = q.peek().s;
            int d = q.peek().d;

            q.remove();

            dist[row][col] = d;

            for (int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc, d + 1));
                }
            }
        }

        return dist;

    }

}
