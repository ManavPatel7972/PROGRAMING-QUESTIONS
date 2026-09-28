import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        int[][] points = {
                { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 }
        };

        // expected output = 20

        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();
        System.out.println("Res = " + obj.minCost(points));
    }

    public int minCost(int[][] points) {

        int n = points.length;
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.get(i).add(new int[] { j, dist });
                adj.get(j).add(new int[] { i, dist });
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] vis = new int[n];
        pq.add(new int[] { 0, 0 });
        int minCost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int wt = curr[1];

            if (vis[node] == 1) {
                continue;
            }

            vis[node] = 1;
            minCost += wt;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edgeWt = it[1];

                if (vis[adjNode] == 0) {
                    pq.add(new int[] { adjNode, edgeWt });
                }
            }
        }

        return minCost;

    }
}
