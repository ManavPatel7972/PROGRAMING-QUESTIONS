package BinarySearchTree;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class LCAOfBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        TreeNode p = new TreeNode(4);
        TreeNode q = new TreeNode(2);
        TreeNode node = lca(root, p, q);

        System.out.println("LCA = " + node.data);
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        int curr = root.data;

        if (curr < p.data && curr < q.data) {
            return lca(root.right, p, q);
        }

        if (curr > p.data && curr > q.data) {
            return lca(root.left, p, q);
        }

        return root;
    }
}
