package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        left = right = null;
    }
}

public class PredecessorInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode p = root.right;

        TreeNode pre = pre(root, p);

        if (pre != null) {
            System.out.println("Inorder Predecessor of " + p.val + " is: " + pre.val);
        } else {
            System.out.println("Inorder Predecessor of " + p.val + " does not exist.");
        }

    }

    public static TreeNode pre(TreeNode root, TreeNode p) {
        TreeNode pre = null;

        while (root != null) {
            if (p.val > root.val) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return pre;
    }

}