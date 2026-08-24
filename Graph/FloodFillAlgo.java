public class FloodFillAlgo {
    public static void main(String[] args) {
        int[][] img = {
                { 1, 1, 1, 0 },
                { 0, 1, 1, 1 },
                { 1, 0, 1, 1 },
        };

        int sr = 1, sc = 2;
        int newColor = 2;

        int[][] arr = floodFill(img, sr, sc, newColor);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFill(int[][] img, int sr, int sc, int newColor) {

        if (img[sr][sc] == newColor) {
            return img;
        }

        int oldColor = img[sr][sc];
        img[sr][sc] = newColor;

        dfs(img, sr, sc, oldColor, newColor);

        return img;

    }

    public static void dfs(int[][] img, int i, int j, int oldColor, int newColor) {

        int n = img.length;
        int m = img[0].length;

        if (i - 1 >= 0 && img[i - 1][j] == oldColor) {
            img[i - 1][j] = newColor;
            dfs(img, i - 1, j, oldColor, newColor);
        }

        if (i + 1 < n && img[i + 1][j] == oldColor) {
            img[i + 1][j] = newColor;
            dfs(img, i + 1, j, oldColor, newColor);
        }

        if (j - 1 >= 0 && img[i][j - 1] == oldColor) {
            img[i][j - 1] = newColor;
            dfs(img, i, j - 1, oldColor, newColor);
        }

        if (j + 1 < m && img[i][j + 1] == oldColor) {
            img[i][j + 1] = newColor;
            dfs(img, i, j + 1, oldColor, newColor);
        }

    }
}
