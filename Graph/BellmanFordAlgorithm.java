import java.util.ArrayList;

public class BellmanFordAlgorithm {
    public static void main(String[] args) {

    }

    public static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int S) {

        int[] dist = new int[V];
        for (int i = 0; i < V; i++) {
            dist[i] = (int) (1e8);
        }

        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {

            for (ArrayList<Integer> it : adj) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // check for if negative cycle (Nth iteration)
        for (ArrayList<Integer> it : adj) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                return new int[] { -1 };
            }
        }

        return dist;
    }
}