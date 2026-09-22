import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };

        PathWithMinimumEffort obj = new PathWithMinimumEffort();

        int ans = obj.minimumEffort(heights);

        System.out.println(ans);

    }

    public int minimumEffort(int[][] grid) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int[] r : dist) {
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        pq.add(new int[] { 0, 0, 0 });

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int diff = arr[0];
            int row = arr[1];
            int col = arr[2];

            if (row == n - 1 && col == n - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newR = row + dr[i];
                int newC = col + dc[i];

                if (newR >= 0 && newR < n && newC >= 0 && newC < m) {
                    int newEff = Math.max(Math.abs(grid[row][col] - grid[newR][newC]), diff);

                    if (newEff < dist[newR][newC]) {
                        dist[newR][newC] = newEff;
                        pq.add(new int[] { newEff, newR, newC });
                    }
                }
            }
        }

        return 0;
    }
}
