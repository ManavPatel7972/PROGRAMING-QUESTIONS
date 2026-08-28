import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Test {
    int node;
    int parent;

    Test(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class FindShortestCycle {

    public static void main(String[] args) {

        int n = 7;

        int[][] edges = {
                { 0, 1 },
                { 1, 2 },
                { 2, 0 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 3 }
        };

        FindShortestCycle obj = new FindShortestCycle();

        int ans = obj.findShortestCycle(n, edges);

        System.out.println(ans);
    }

    // using bfs
    public int findShortestCycle(int n, int[][] arr) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : arr) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            int len = bfs(i, adj, n);

            if (len != -1) {
                ans = Math.min(ans, len);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int bfs(
            int node,
            ArrayList<ArrayList<Integer>> adj,
            int n) {

        Queue<Test> q = new LinkedList<>();

        int[] vis = new int[n];
        int[] distance = new int[n];

        q.add(new Test(node, -1));

        vis[node] = 1;
        distance[node] = 0;

        int shortestCycle = Integer.MAX_VALUE;

        while (!q.isEmpty()) {

            Test p = q.poll();

            int currNode = p.node;
            int parent = p.parent;

            for (int it : adj.get(currNode)) {

                if (vis[it] == 0) {

                    vis[it] = 1;

                    distance[it] = distance[currNode] + 1;

                    q.add(new Test(it, currNode));

                } else if (parent != it) {

                    int cycleLength = distance[currNode]
                            + distance[it]
                            + 1;

                    shortestCycle = Math.min(shortestCycle, cycleLength);
                }
            }
        }

        return shortestCycle == Integer.MAX_VALUE
                ? -1
                : shortestCycle;
    }
}