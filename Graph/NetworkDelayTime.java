import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {

    }

    public int networkDelay_Bellman(int[][] times, int n, int k) {
        // convert 0 based index
        k = k - 1;

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // source
        dist[k] = 0;

        for (int i = 0; i < n - 1; i++) {

            for (int[] it : times) {
                // 0 Based so -1;
                int u = it[0] - 1;
                int v = it[1] - 1;
                int wt = it[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }

            }
        }

        // max distance
        int ans = 0;

        for (int d : dist) {

            if (d == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, d);
        }

        return ans;

    }

    public int networkDelay_Dijkstra(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] it : times) {
            int u = it[0] - 1;
            int v = it[1] - 1;
            int w = it[2];

            adj.get(u).add(new int[] { v, w });
        }

        // convert 0 based index
        k = k - 1;

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // source
        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, k });

        while (!pq.isEmpty()) {
            int[] pair = pq.poll();
            int dst = pair[0];
            int node = pair[1];

            if (dst > dist[node]) {
                continue;
            }

            for (int[] it : adj.get(node)) {
                int nearNode = it[0];
                int wt = it[1];

                int newDist = dst + wt;
                if (newDist < dist[nearNode]) {
                    dist[nearNode] = newDist;
                    pq.add(new int[] { newDist, nearNode });
                }
            }

        }

        // max distance
        int ans = 0;

        for (int d : dist) {

            if (d == Integer.MAX_VALUE) {
                return -1;
            }

            ans = Math.max(ans, d);
        }

        return ans;

    }
}
