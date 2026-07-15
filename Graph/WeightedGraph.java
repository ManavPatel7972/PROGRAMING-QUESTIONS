import java.util.ArrayList;
import java.util.Scanner;

class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }
}


public class WeightedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // number of nodes
        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt(); 

        // number of edges
        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt(); 

        ArrayList<ArrayList<Pair<Integer,Integer>>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair<Integer,Integer>>());
        }

        for(int i=0;i<m;i++){
            
            System.out.println("Enter the edges in the format: u v w (where u and v are nodes and w is the weight): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // add edges to the adjacency list

            adj.get(u).add(new Pair<>(v,w));
            adj.get(v).add(new Pair<>(u,w));
        }

        sc.close();
        
        // print the adjacency list
        System.out.println("Adjacency List:");
        
        for(int i=0;i<=n;i++){
            System.out.print(i + ": ");
            for(Pair<Integer,Integer> p : adj.get(i)){
                System.out.print("(" + p.getFirst() + ", " + p.getSecond() + ") ");
            }
            System.out.println();
        }

    }  

    // output for the input:
    // 5 6
    // 0 1 2
    // 0 2 4
    // 1 2 1
    // 1 3 7
    // 2 4 3    


}

