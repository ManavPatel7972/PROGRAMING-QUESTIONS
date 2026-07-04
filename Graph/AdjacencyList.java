import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of nodes
        int n = sc.nextInt(); 
        // number of edges
        int m = sc.nextInt(); 

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        sc.close();


    }
}
