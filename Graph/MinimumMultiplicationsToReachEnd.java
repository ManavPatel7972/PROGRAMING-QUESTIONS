import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {

        int[] arr = { 2, 5, 7 };
        int start = 3;
        int end = 30;

        MinimumMultiplicationsToReachEnd obj = new MinimumMultiplicationsToReachEnd();

        System.out.println("Ans = " + obj.minimumMulti(arr, start, end));

    }

    public int minimumMulti(int[] arr, int start, int end) {

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int mod = 100000;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, start });

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int step = curr[0];
            int node = curr[1];

            for (int i : arr) {
                int num = (i * node) % mod;

                if (step + 1 < dist[num]) {
                    dist[num] = step + 1;

                    if (num == end) {
                        return step + 1;
                    }

                    q.add(new int[] { step + 1, num });
                }
            }

        }

        return -1;
    }
}
