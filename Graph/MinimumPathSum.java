import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumPathSum {
    public static void main(String[] args) {

    }

    public static int minPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dist = new int[m][n];

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];

        // {cost,row,col}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{grid[0][0],0,0});


        int[] dr = {0,1};
        int[] dc = {1,0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == m-1 && c == n-1){
                return cost;
            }

            if(cost > dist[r][c]){
                continue;
            }


            // right and down
            for(int k=0;k<2;k++){
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr<m && nc<n && nr>=0 && nc>=0){
                    int newCost = cost + grid[nr][nc];

                    if(newCost<dist[nr][nc]){
                        dist[nr][nc] = newCost;
                        pq.add(new int[]{newCost,nr,nc});
                    }
                }
            }
        }

        return -1;
    }
}