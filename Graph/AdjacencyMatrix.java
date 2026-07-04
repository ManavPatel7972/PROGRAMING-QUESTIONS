import java.util.Scanner;

public class AdjacencyMatrix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // nodes
        int n = sc.nextInt();

        // edges
        int m = sc.nextInt();


        // matrix (1 Based Index)
        int[][] adj = new int[n+1][n+1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;

            // only if Undirected Graph
            adj[v][u] = 1;
        }

        sc.close();
    }

}