import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {
                { 3, 0 },
                { 1, 0 },
                { 2, 0 },
        };

        TopologicalSort obj = new TopologicalSort();
        ArrayList<Integer> ans = obj.topoSort(V, edges);

        System.out.println(ans.toString());
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, edges, vis, st);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;
    }

    public void dfs(int node, int[][] edges, int[] vis, Stack<Integer> st) {
        vis[node] = 1;

        for (int[] edge : edges) {
            if (vis[edge[0]] == 0 && edge[1] == node) {
                dfs(edge[0], edges, vis, st);
            }
        }
    }

    public int[] topoSortList(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsList(i, adj, st, vis);
            }
        }

        int[] ans = new int[V];
        int i = 0;

        while (!st.isEmpty()) {
            ans[i++] = st.pop();
        }

        return ans;
    }

    public void dfsList(int node, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st, int[] vis) {
        vis[node] = 1;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                dfsList(node, adj, st, vis);
            }
        }
        st.push(node);
    }
}
