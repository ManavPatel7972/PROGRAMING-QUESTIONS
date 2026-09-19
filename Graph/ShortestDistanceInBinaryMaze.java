import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int dist;
    int row;
    int col;

    Pair(int dist, int row, int col) {
        this.dist = dist;
        this.row = row;
        this.col = col;

    }
}

public class ShortestDistanceInBinaryMaze {
    public static void main(String[] args) {
        int[] source = { 0, 1 };
        int[] destination = { 2, 2 };

        int[][] grid = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 }
        };

        ShortestDistanceInBinaryMaze obj = new ShortestDistanceInBinaryMaze();

        int res = obj.shortestPath(grid, source, destination);

        System.out.println(res);

    }

    public int shortestPath(int[][] grid, int[] source, int[] destination) {

        if (source[0] == destination[0] && source[1] == destination[1]) {

            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[grid.length][grid[0].length];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[source[0]][source[1]] = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, source[0], source[1]));

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int dis = p.dist;
            int r = p.row;
            int c = p.col;

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newR < n && newC >= 0 && newC < m && grid[newR][newC] == 1
                        && dis + 1 < dist[newR][newC]) {
                    dist[newR][newC] = dis + 1;

                    if (newR == destination[0] && newC == destination[1]) {
                        return dis + 1;
                    }

                    q.add(new Pair(dis + 1, newR, newC));
                }
            }
        }

        return -1;

    }
}