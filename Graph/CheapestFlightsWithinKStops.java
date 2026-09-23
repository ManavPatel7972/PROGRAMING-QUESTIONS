import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithinKStops {
    public static void main(String[] args) {
        int n = 3;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };

        int src = 0, dst = 2, k = 1;

        CheapestFlightsWithinKStops obj = new CheapestFlightsWithinKStops();

        System.out.println("Ans = " + obj.findCheapestPrice(n, flights, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // make it adjList
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new int[] { f[1], f[2] });
        }

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // int[] -> {step, node, dist};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, src, 0 });

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int step = curr[0];
            int node = curr[1];
            int dis = curr[2];

            if (step > k)
                break;

            for (int[] adjNode : adj.get(node)) {
                int nextNode = adjNode[0];
                int cost = adjNode[1];

                if (dis + cost < dist[nextNode] && step <= k) {
                    dist[nextNode] = cost + dis;
                    q.add(new int[] { step + 1, nextNode, cost + dis });
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return dist[dst];
    }
}
