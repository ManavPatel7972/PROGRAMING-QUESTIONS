import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    int curr;
    int parent;

    Pair(int curr, int parent) {
        this.curr = curr;
        this.parent = parent;
    }
}

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 3, 4 } };
        boolean hasCycle = isCycle(V, edges);
        System.out.println("Graph has cycle: " + hasCycle);
    }

    public static boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = constructAdj(V, edges);

        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                if (bfs(i, adj, vis))
                    return true;
            }
        }

        return false;
    }


    public static boolean bfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));

        while (!q.isEmpty()) {
            int curr = q.peek().curr;
            int parent = q.peek().parent;
            q.remove();

            for (int adjNode : adj.get(node)) {
                if (vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode, curr));

                    // if already visited but not the parent so cycle;
                } else if (parent != adjNode) {
                    return true;
                }
            }
        }

        

        return false;
    }

    public static List<List<Integer>> constructAdj(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return adj;
    }
}
