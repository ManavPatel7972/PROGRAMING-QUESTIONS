import java.util.ArrayList;
import java.util.List;

public class N_Queens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);

        for (List<String> list : res) {
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allSol = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board, allSol, 0);

        return allSol;
    }

    public static void helper(char[][] board, List<List<String>> allSol, int col) {

        if (col == board[0].length) {
            saveSol(board, allSol);
            return;
        }

        for (int r = 0; r < board.length; r++) {
            if (isSafe(r, col, board)) {
                board[r][col] = 'Q';
                helper(board, allSol, col + 1);
                board[r][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board) {

        // // horizontal
        // for (int j = 0; j < board[0].length; j++) {
        // if (board[row][j] == 'Q') {
        // return false;
        // }
        // }

        // // vertical
        // for (int i = 0; i < board.length; i++) {
        // if (board[i][col] == 'Q') {
        // return false;
        // }
        // }

        int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

        for (int i = 0; i < 8; i++) {
            int r = row + dr[i];
            int c = col + dc[i];

            while (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                if (board[r][c] == 'Q') {
                    return false;
                }
                r += dr[i];
                c += dc[i];
            }
        }
        return true;
    }

    public static void saveSol(char[][] board, List<List<String>> allSol) {
        String row = "";
        List<String> li = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            li.add(row);
        }

        allSol.add(li);
    }
}