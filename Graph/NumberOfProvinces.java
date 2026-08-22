import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args) {
        int[][] adj = {
                { 1, 0, 1 },
                { 0, 1, 0 },
                { 1, 0, 1 }
        };
        int V = 3;

        System.out.println(numberOfProvinces(V, adj));
    }

    // public static int numberOfProvinces(int V, int[][] edges) {
    // List<List<Integer>> adj = new ArrayList<>();

    // for (int i = 0; i < V; i++) {
    // adj.add(new ArrayList<>());
    // }

    // for (int i = 0; i < V; i++) {
    // for (int j = 0; j < edges[i].length; j++) {
    // if (edges[i][j] == 1 && i != j) {

    // adj.get(i).add(j);
    // adj.get(j).add(i);
    // }
    // }
    // }

    // boolean[] vis = new boolean[V];

    // int cnt = 0;

    // for (int i = 0; i < V; i++) {
    // if (!vis[i]) {
    // cnt++;
    // dfs(i, adj, vis);
    // }
    // }

    // return cnt;
    // }

    // public static void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
    // vis[node] = true;
    // for (int near : adj.get(node)) {
    // if (!vis[near]) {
    // dfs(near, adj, vis);
    // }
    // }
    // }

    public static int numberOfProvinces(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                bfs(i, adj, vis);
            }
        }

        return count;
    }

    public static void bfs(int node, int[][] adj, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        vis[node] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < adj.length; i++) {
                if (adj[curr][i] == 1 && !vis[i]) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }

    }

}