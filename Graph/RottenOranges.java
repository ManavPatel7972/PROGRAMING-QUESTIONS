import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int tm;

    public Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class RottenOranges {

    public static void main(String[] args) {

    }

    public static int rottenOranges(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }

                if (arr[i][j] == 1) {
                    countFresh++;
                }
            }

        }

        int totalTime = 0;

        while (!q.isEmpty()) {

            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.remove();

            totalTime = Math.max(totalTime, t);

            // up
            if (r - 1 >= 0 && vis[r - 1][c] != 2 && arr[r - 1][c] == 1) {
                q.add(new Pair(r - 1, c, t + 1));
                vis[r - 1][c] = 2;
                countFresh--;
            }

            // down
            if (r + 1 < n && vis[r + 1][c] != 2 && arr[r + 1][c] == 1) {
                q.add(new Pair(r + 1, c, t + 1));
                vis[r + 1][c] = 2;
                countFresh--;

            }

            // left
            if (c - 1 >= 0 && vis[r][c - 1] != 2 && arr[r][c - 1] == 1) {
                q.add(new Pair(r, c - 1, t + 1));
                vis[r][c - 1] = 2;
                countFresh--;

            }

            // right
            if (c + 1 < m && vis[r][c + 1] != 2 && arr[r][c + 1] == 1) {
                q.add(new Pair(r, c + 1, t + 1));
                vis[r][c + 1] = 2;
                countFresh--;
            }

        }

        if (countFresh > 0) {
            return -1;
        }

        return totalTime;
    }

}
