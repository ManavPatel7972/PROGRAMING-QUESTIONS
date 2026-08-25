import java.rmi.server.LogStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    int[] delRow = { -1, 0, 1, 0 };
    int[] delCol = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1 },
                { 1, 1, 0, 1, 0 }
        };

        NumberOfDistinctIslands obj = new NumberOfDistinctIslands();

        System.out.println("NumberOfDistinctIslands = " + obj.numberOfDistinctIslands(arr));
    }

    public int numberOfDistinctIslands(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<Integer>> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && arr[i][j] == 1) {
                    ArrayList<Integer> vec = new ArrayList<>();
                    dfs(i, j, arr, vis, vec, i, j);
                    s.add(vec);
                }

            }
        }

        return s.size();

    }

    public void dfs(int i, int j, int[][] arr, int[][] vis, ArrayList<Integer> vec, int row0, int col0) {
        vis[i][j] = 1;

        vec.add(i - row0);
        vec.add(j - col0);

        for (int k = 0; k < 4; k++) {
            int nr = i + delRow[k];
            int nc = j + delCol[k];

            if (nr >= 0 && nr < arr.length && nc >= 0 && nc < arr[0].length
                    && vis[nr][nc] == 0 && arr[nr][nc] == 1) {
                dfs(nr, nc, arr, vis, vec, row0, col0);
            }
        }

    }
}
