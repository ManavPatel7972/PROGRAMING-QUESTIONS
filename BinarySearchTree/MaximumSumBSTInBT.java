package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Info {
    boolean isBST;
    int min, max, sum;

    Info(boolean isBST, int min, int max, int sum) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
        this.sum = sum;
    }
}

public class MaximumSumBSTInBT {

    private static int maxSum = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(4);
        root.right.right.right = new TreeNode(6);

        System.out.println("MAX SUM = " + maxSumBST(root));
    }

    public static int maxSumBST(TreeNode root) {
        if (root == null)
            return 0;

        maxSum = 0;

        helper(root);
        return maxSum;
    }

    public static Info helper(TreeNode root) {

        // valid BST
        if (root == null) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {
            int currSum = left.sum + right.sum + root.val;
            maxSum = Math.max(currSum, maxSum);

            int currMin = Math.min(left.min, root.val);
            int currMax = Math.max(right.max, root.val);

            return new Info(true, currMin, currMax, currSum);
        }

        return new Info(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

}