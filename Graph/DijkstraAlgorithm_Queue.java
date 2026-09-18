import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class DijkstraAlgorithm_Queue {
    public static void main(String[] args) {
        int V = 5;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // 0 -> 1 (4)
        adj.get(0).add(new Pair(1, 4));

        // 0 -> 2 (1)
        adj.get(0).add(new Pair(2, 1));

        // 2 -> 1 (2)
        adj.get(2).add(new Pair(1, 2));

        // 2 -> 3 (5)
        adj.get(2).add(new Pair(3, 5));

        // 1 -> 3 (1)
        adj.get(1).add(new Pair(3, 1));

        // 3 -> 4 (3)
        adj.get(3).add(new Pair(4, 3));

        dijkstra(V, adj, 0);
    }

    public static void dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int source) {

        int[] dist = new int[V];

        // Initially all distances are infinity
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Source distance = 0
        dist[source] = 0;

        // Normal Queue
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {

            int node = queue.poll();

            // Visit all adjacent nodes
            for (Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                // Relaxation
                if (dist[node] + edgeWeight < dist[nextNode]) {

                    dist[nextNode] = dist[node] + edgeWeight;

                    queue.add(nextNode);
                }
            }
        }

        // Print result
        System.out.println("Shortest distances from " + source + ":");

        for (int i = 0; i < V; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
    }

}
