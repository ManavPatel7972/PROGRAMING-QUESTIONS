package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class Demo {
    boolean isBST;
    int max, min, size;

    Demo(boolean isBST, int min, int max, int size) {
        this.isBST = isBST;
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

public class MaximumSizeBSTInBT {

    private static int maxSize = 0;

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

        System.out.println("MAX NODE = " + maxNode(root));
    }

    public static int maxNode(TreeNode root) {
        if (root == null)
            return 0;

        maxSize = 0;

        helper(root);

        return maxSize;

    }

    private static Demo helper(TreeNode root) {
        // valid BST
        if (root == null) {
            return new Demo(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        Demo left = helper(root.left);
        Demo right = helper(root.right);

        if (left.isBST && right.isBST && left.max < root.val && root.val < right.min) {

            int currSize = left.size + right.size + 1;

            maxSize = Math.max(maxSize, currSize);

            int currMin = Math.min(left.min, root.val);
            int currMax = Math.max(right.max, root.val);

            return new Demo(true, currMin, currMax, currSize);
        }

        return new Demo(false, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
}
