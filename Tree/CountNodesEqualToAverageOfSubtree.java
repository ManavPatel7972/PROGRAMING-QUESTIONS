class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class CountNodesEqualToAverageOfSubtree {

    int ans = 0;

    public static void main(String[] args) {

    }

    public int averageNode(TreeNode root) {
        if (root == null)
            return 0;

        dfs(root);

        return ans;
    }

    public int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 0, 0 };

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = left[0] + right[0] + root.val;
        int count = left[1] + right[1] + 1;

        if (sum / count == root.val) {
            ans++;
        }

        return new int[] { sum, count };
    }
}