import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        ArrayList<Integer> bfs = bfsOfGraph(V, adj);

        for (Integer it : bfs) {
            System.out.println(it);
        }

        sc.close();
    }

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        // ArrayList<Integer> bfs = new ArrayList<>();
        // boolean[] vis = new boolean[V];

        // Queue<Integer> q = new LinkedList<>();
        // // starting Node
        // q.add(0);
        // vis[0] = true;

        // while (!q.isEmpty()) {
        // int node = q.poll();
        // bfs.add(node);

        // // get all adjacent vertices
        // // if adj is not visited then traversal and then mark has visited

        // for (int it : adj.get(node)) {
        // if (vis[node] == false) {
        // vis[it] = true;
        // q.add(it);
        // }
        // }
        // }

        // return bfs;

        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            // for (Integer integer : adj.get(node)) {
            // if (vis[integer] == false) {
            // q.add(integer);
            // vis[integer] = true;
            // }
            // }

            for (int i = 0; i < adj.get(node).size(); i++) {
                int temp = adj.get(node).get(i);
                if (vis[temp] == false) {
                    vis[temp] = true;
                    q.add(temp);
                }
            }
        }

        return bfs;

    }
}
