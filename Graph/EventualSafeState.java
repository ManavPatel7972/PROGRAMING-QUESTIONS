import java.util.ArrayList;
import java.util.List;

public class EventualSafeState {

    public static void main(String[] args) {
        int[][] graph = {
                { 1, 2 },
                { 2, 3 },
                { 5 },
                { 0 },
                { 5 },
                {},
                {},
        };

        EventualSafeState obj = new EventualSafeState();

        List<Integer> ans = obj.eventualSafeNodes(graph);

        System.out.println(ans.toString());

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());

            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }

        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, adj, vis, pathVis, check);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (check[i] == 1)
                ans.add(i);
        }

        return ans;

    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;

        // check[node] = 0;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, pathVis, check) == true) {
                    check[node] = 0;
                    return true;
                }
            } else if (pathVis[it] == 1) {
                check[node] = 0;
                return true;
            }
        }

        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}
