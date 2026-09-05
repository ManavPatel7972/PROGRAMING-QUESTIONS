import java.util.ArrayList;
import java.util.Stack;

class Pair4 {
    int node;
    int weight;

    Pair4(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathInDAG {
    public static void main(String[] args) {
        int N = 9, M = 10;
        int[][] edges = {
                { 0, 1, 2 }, { 0, 4, 1 }, { 4, 5, 4 },
                { 4, 2, 2 }, { 1, 2, 3 }, { 2, 3, 6 }, { 5, 3, 1 }
        };

        ShortestPathInDAG obj = new ShortestPathInDAG();

        int[] res = obj.shortestPath(N, M, edges, 0);

        for (int val : res) {
            System.out.print(val + " ");
        }

    }

    public int[] shortestPath(int N, int M, int[][] edges, int source) {

        ArrayList<ArrayList<Pair4>> adj = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair4(v, wt));
        }

        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[source] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).weight;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }

        }

        return dist;
    }

    public static void topoSort(int node, ArrayList<ArrayList<Pair4>> adj, int[] vis, Stack<Integer> st) {

        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).node;
            if (vis[v] == 0) {
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }

}
