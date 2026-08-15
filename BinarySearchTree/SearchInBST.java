package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SearchInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root, 2);

        if (result != null)
            System.out.println("Node found: " + result.val);
        else
            System.out.println("Node not found");
    }

    public static TreeNode searchBST(TreeNode root, int target) {
        while (root != null && root.val != target) {
            root = root.val > target ? root.left : root.right;
        }

        return root;
    }
}
