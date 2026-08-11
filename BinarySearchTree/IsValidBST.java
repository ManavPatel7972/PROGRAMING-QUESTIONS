package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

public class IsValidBST {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.left.right = new Node(2);
        root.right = new Node(4);
        root.right.right = new Node(-1);

        if (isValid(root)) {
            System.out.println("Valid BST");
        } else {
            System.out.println("Not Valid BST");
        }
    }

    public static boolean isValidBrute(TreeNode root) {
        // in This approach first i store all node using inOrder Traversal
        // after check is list is sorted Or Not
        // if it is sorted return true else return false

        List<Long> li = new ArrayList<>();
        inOrder(root, li);
        for (int i = 1; i < li.size(); i++) {
            if (li.get(i) <= li.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void inOrder(TreeNode root, List<Long> li) {
        if (root == null)
            return;

        inOrder(root.left, li);
        li.add((long) root.val);
        inOrder(root.right, li);
    }

    public static boolean isValid(Node root) {
        if (root == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean helper(Node root, long minVal, long maxVal) {
        if (root == null)
            return true;

        if (root.data >= maxVal || root.data <= minVal)
            return false;

        return helper(root.left, minVal, root.data) && helper(root.right, root.data, maxVal);
    }
}
