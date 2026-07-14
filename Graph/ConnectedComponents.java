import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public static void main(String[] args) {

        int V = 5;

        // List of undirected edges
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};

        System.out.println("Number of Connected Components: " + countComponents(V, edges));
    }

    public static int countComponents(int V, int[][] edges){

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        boolean[] vis = new boolean[V];

        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                cnt++;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (Integer it : adj.get(node)) {
                        if(!vis[it]){
                            vis[it] = true;
                            q.add(it);
                        }
                    }

                }


            }
        }

        return cnt;
    }
}
