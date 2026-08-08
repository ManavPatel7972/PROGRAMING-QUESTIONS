package BinarySearchTree;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class FloorAndCeilOfBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);

        System.out.println("ceil = " + floor(root, 8));

    }

    public static int floor(TreeNode root, int key) {
        if (root == null)
            return -1;

        int floor = -1;

        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }

            if (key > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }

        return floor;

    }

    public static int ceil(TreeNode root, int key) {
        if (root == null)
            return -1;

        int ceil = -1;

        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }

            if (key < root.val) {
                ceil = root.val;
                root = root.left;

            } else {
                root = root.right;

            }
        }

        return ceil;

    }

}