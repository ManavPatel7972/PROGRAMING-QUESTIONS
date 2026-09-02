public class WordSearch {
    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        int[][] vis = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (dfs(board, word, i, j, 0, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int idx, int[][] vis) {
        if (idx == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (vis[row][col] == 1) {
            return false;
        }

        if (board[row][col] != word.charAt(idx)) {
            return false;
        }

        vis[row][col] = 1;

        boolean found = dfs(board, word, row + 1, col, idx + 1, vis) || dfs(board, word, row - 1, col, idx + 1, vis)
                || dfs(board, word, row, col + 1, idx + 1, vis) || dfs(board, word, row, col - 1, idx + 1, vis);

        vis[row][col] = 0;

        return found;
    }

}