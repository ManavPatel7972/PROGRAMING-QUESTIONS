import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {

    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (check(i, V, adj, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int i : adj.get(node)) {

                if (color[i] == -1) {
                    color[i] = 1 - color[node];
                    q.add(i);
                }

                else if (color[i] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, graph, color) == false) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int node, int c, int[][] graph, int[] color) {
        color[node] = c;

        for (int j = 0; j < graph[node].length; j++) {

            int near = graph[node][j];

            if (color[near] == -1) {
                if (dfs(near, 1 - c, graph, color) == false)
                    return false;
            } else if (color[near] == c) {
                return false;
            }
        }
        return true;
    }

}