import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraphWithUnitWeight {
    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
                { 0, 1 }, { 0, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 },
                { 1, 2 }, { 2, 6 }, { 6, 7 }, { 7, 8 }, { 6, 8 }
        };

        ShortestPathInUndirectedGraphWithUnitWeight obj = new ShortestPathInUndirectedGraphWithUnitWeight();

        int[] res = obj.shortestPath(edges, N, M, 0);

        for (int val : res) {
            System.out.print(val + " ");
        }
    }

    public int[] shortestPath(int[][] edges, int N, int M, int source) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int[] dist = new int[N];

        Arrays.fill(dist, (int) 1e9);

        dist[source] = 0;

        // for bfs
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int near : adj.get(node)) {
                if (dist[node] + 1 < dist[near]) {
                    dist[near] = dist[node] + 1;
                    q.add(near);
                }
            }
        }

        // replace infinity with -1;
        for (int i = 0; i < N; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;

    }
}
