package String;

import java.util.HashSet;
import java.util.Set;

public class CheckIfThereIsAValidParenthesisStringPath {

    int m, n;
    Set<String> vis = new HashSet<>();

    public static void main(String[] args) {

    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 != 0)
            return false;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }

        return dfs(grid, 0, 0, 0);
    }

    public boolean dfs(char[][] grid, int i, int j, int balance) {

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0) {
            return false;
        }

        String key = i + "," + j + "," + balance;

        if (vis.contains(key)) {
            return false;
        }

        vis.add(key);

        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if (i + 1 < m) {
            if (dfs(grid, i + 1, j, balance)) {
                return true;
            }
        }

        if (j + 1 < n) {
            if (dfs(grid, i, j + 1, balance)) {
                return true;
            }
        }

        return false;
    }

}
