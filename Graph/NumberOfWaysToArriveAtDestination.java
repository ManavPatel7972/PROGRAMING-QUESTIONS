import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 },
                { 3, 5, 1 }, { 6, 5, 1 }, { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };

        int src = 0;
        int dst = 3;

        NumberOfWaysToArriveAtDestination obj = new NumberOfWaysToArriveAtDestination();
        System.out.println("Ans = " + obj.numberOfWays(n, roads, src, dst));
    }

    public int numberOfWays(int n, int[][] roads, int src, int dst) {

        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] r : roads) {
            adj.get(r[0]).add(new int[] { r[1], r[2] });
            adj.get(r[1]).add(new int[] { r[0], r[2] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, src });

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        int[] ways = new int[n];
        ways[src] = 1;

        int mod = (int) (1e9 + 7);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            for (int[] near : adj.get(node)) {
                int adjNode = near[0];
                int cost = near[1];

                if (dis + cost < dist[adjNode]) {
                    dist[adjNode] = dis + cost;
                    pq.add(new int[] { dis + cost, adjNode });
                    ways[adjNode] = ways[node];
                } else if (dis + cost == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[dst] % mod;

    }
}
