class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumOfLeaves {
    public static void main(String[] args) {

    }

    public int sumOfLeaves(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root);
    }

    public int helper(TreeNode root) {

        int ans = 0;

        if (root == null)
            return 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        } else {
            ans += helper(root.left);
        }

        ans += helper(root.right);

        return ans;
    }
}