import java.util.ArrayList;
import java.util.Scanner;

public class Dfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> dfs = dfsOfGraph(V, adj);

        for (Integer it : dfs) {
           System.out.print(it + " ");
        }

        sc.close();
    }
    
    public static ArrayList<Integer> dfsOfGraph(int V,ArrayList<ArrayList<Integer>> adj){

        ArrayList<Integer> ls = new ArrayList<>();
        boolean[] vis = new boolean[V+1];

        // stating Node
        vis[0] = true;

        dfs(0,vis, adj,ls);
        return ls;

    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){

        vis[node] = true;
        ls.add(node);

        for (Integer it : adj.get(node)) {
            if(vis[it] == false){
                dfs(it, vis, adj, ls);
            }
        }
    }
}
