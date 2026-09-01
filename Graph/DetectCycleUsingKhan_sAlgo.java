import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleUsingKhan_sAlgo {

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges
        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        DetectCycleUsingKhan_sAlgo obj = new DetectCycleUsingKhan_sAlgo();

        System.out.println("IsCycle = " + obj.isCycle_Khan_sAlgo(V, adj));

    }

    public boolean isCycle_Khan_sAlgo(int V, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while (q.isEmpty()) {
            int node = q.poll();
            cnt++;

            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0)
                    q.add(it);
            }
        }

        if (cnt != V)
            return false;
        return true;
    }

}
