package BinarySearchTree;

public class DeleteNodeInBST {
    public static void main(String[] args) {

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {

            // case 1: both child null
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: only right child
            if (root.left == null) {
                return root.right;
            }

            // case 3: only left child
            if (root.right == null) {
                return root.left;
            }

            // case 4: both child preset
            // find inOrder successor for right child smallest left
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            // replace curr root val to successor
            root.val = successor.val;

            // delete the duplicated successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}
