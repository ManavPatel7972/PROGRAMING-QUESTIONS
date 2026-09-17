import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithm_PriorityQueue {

    public static void main(String[] args) {
        int V = 3, S = 2;

        ArrayList<int[]>[] adj = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[0].add(new int[] { 1, 1 });
        adj[0].add(new int[] { 2, 6 });
        adj[1].add(new int[] { 2, 3 });
        adj[1].add(new int[] { 0, 1 });
        adj[2].add(new int[] { 1, 3 });
        adj[2].add(new int[] { 0, 6 });

        DijkstraAlgorithm_PriorityQueue obj = new DijkstraAlgorithm_PriorityQueue();

        int[] res = obj.dijkstra(V, adj, S);

        for (int i = 0; i < V; i++) {
            System.out.print(res[i] + " ");
        }

        System.out.println();

    }

    public int[] dijkstra(int V, ArrayList<int[]>[] adj, int S) {

        // priority queue to store the nodes as a pair {dist, node}
        // The queue will always return the node with the smallest distance first

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;
        pq.add(new int[] { 0, S });

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int dis = curr[0];
            int node = curr[1];

            for (int[] edge : adj[node]) {
                int adjNode = edge[0];
                int weight = edge[1];

                if (dis + weight < dist[adjNode]) {
                    dist[adjNode] = dis + weight;
                    pq.add(new int[] { dist[adjNode], adjNode });
                }
            }
        }

        return dist;

    }

}

// ! -----------------------------------ADJ LIST--------------------

// import java.util.*;

// class Pair {
// int node;
// int distance;

// Pair(int node, int distance) {
// this.node = node;
// this.distance = distance;
// }
// }

// public class DijkstraAlgorithm {

// static void dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int source) {

// int[] dist = new int[V];

// // Initially all distances are infinity
// Arrays.fill(dist, Integer.MAX_VALUE);

// // Source distance = 0
// dist[source] = 0;

// // Queue sorted according to distance
// PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance -
// b.distance);

// pq.add(new Pair(source, 0));

// while (!pq.isEmpty()) {

// Pair current = pq.poll();

// int node = current.node;
// int distance = current.distance;

// // Check all adjacent nodes
// for (Pair neighbor : adj.get(node)) {

// int nextNode = neighbor.node;
// int edgeWeight = neighbor.distance;

// // Relaxation
// if (distance + edgeWeight < dist[nextNode]) {

// dist[nextNode] = distance + edgeWeight;

// pq.add(new Pair(nextNode, dist[nextNode]));
// }
// }
// }

// // Print shortest distances
// System.out.println("Shortest distances from source " + source + ":");

// for (int i = 0; i < V; i++) {
// System.out.println(i + " -> " + dist[i]);
// }
// }

// public static void main(String[] args) {

// int V = 5;

// ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

// for (int i = 0; i < V; i++) {
// adj.add(new ArrayList<>());
// }

// // Graph
// adj.get(0).add(new Pair(1, 4));
// adj.get(0).add(new Pair(2, 1));

// adj.get(2).add(new Pair(1, 2));
// adj.get(2).add(new Pair(3, 5));

// adj.get(1).add(new Pair(3, 1));

// adj.get(3).add(new Pair(4, 3));

// dijkstra(V, adj, 0);
// }
// }