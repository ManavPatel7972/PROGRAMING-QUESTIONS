import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new int[] { 1, 5 });
        adj.get(1).add(new int[] { 0, 5 });

        adj.get(1).add(new int[] { 2, 3 });
        adj.get(2).add(new int[] { 1, 3 });

        adj.get(0).add(new int[] { 2, 1 });
        adj.get(2).add(new int[] { 0, 1 });

        System.out.println(spanningTree(V, adj));
    }   

    public static int spanningTree(int V, ArrayList<ArrayList<int[]>> adj) {

        int[] vis = new int[V];
        ArrayList<int[]> mst = new ArrayList<>();

        for (int i = 0; i < V - 1; i++) {
            mst.add(new int[] { -1, -1 });
        }

        // wt,node,parent
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, 0, -1 });

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];
            int parent = curr[2];

            if (vis[node] == 1)
                continue;

            if (parent != -1) {
                mst.add(new int[] { parent, node });
            }

            vis[node] = 1;
            sum += wt;

            for (int[] it : adj.get(node)) {
                int adjNode = it[0];
                int edW = it[1];

                if (vis[adjNode] == 0) {
                    pq.add(new int[] { edW, adjNode, node });
                }
            }

        }


        System.out.println("Edges in the Minimum Spanning Tree:");
        for (int[] edge : mst) {
            if (edge[0] != -1 && edge[1] != -1) {
                System.out.println(edge[0] + " - " + edge[1]);
            }
        }

        return sum;
    }
}
