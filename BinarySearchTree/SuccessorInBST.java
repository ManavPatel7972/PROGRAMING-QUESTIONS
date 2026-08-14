package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        left = right = null;
    }
}

public class SuccessorInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        TreeNode p = root.right;

        TreeNode succe = inOrderSuccessorOptimal(root, p);

        if (succe != null) {
            System.out.println("Inorder Successor of " + p.val + " is: " + succe.val);
        } else {
            System.out.println("Inorder Successor of " + p.val + " does not exist.");
        }

    }

    public static TreeNode inOrderSuccessorOptimal(TreeNode root, TreeNode p) {
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        List<Integer> li = new ArrayList<>();
        printInOrder(root, li);

        int idx = binarySearch(li, p.val);

        if (idx == li.size() - 1 || idx == -1) {
            return null;
        }

        return new TreeNode(li.get(idx + 1));
    }

    public static void printInOrder(TreeNode root, List<Integer> li) {
        if (root == null)
            return;

        printInOrder(root.left, li);
        li.add(root.val);
        printInOrder(root.right, li);

    }

    public static int binarySearch(List<Integer> li, int key) {

        int left = 0;
        int right = li.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (li.get(mid) == key)
                return mid;

            else if (key < li.get(mid)) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return -1;
    }

}
