package BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class RecoverBST {

    static int i = 0;
    private TreeNode first;
    private TreeNode prev;
    private TreeNode middle;
    private TreeNode last;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(2);

        recoverTree(root);

    }

    public void recoverTreeOptimal(TreeNode root) {
        first = middle = last = null;

        prev = new TreeNode(Integer.MIN_VALUE);

        inorder(root);

        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;

        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);

        if (prev != null && (root.val < prev.val)) {
            if (first == null) {
                first = prev;
                middle = root;
            }

            else {
                last = root;
            }
        }

        prev = root;

        inorder(root.right);
    }

    public static void recoverTree(TreeNode root) {
        List<Integer> li = new ArrayList<>();
        inOrder(root, li);

        Collections.sort(li);
        i = 0;

        helper(root, li);
    }

    public static void inOrder(TreeNode root, List<Integer> li) {
        if (root == null)
            return;

        inOrder(root.left, li);
        li.add(root.val);
        inOrder(root.right, li);
    }

    public static void helper(TreeNode root, List<Integer> li) {
        if (root == null)
            return;

        helper(root.left, li);

        if (root.val != li.get(i)) {
            root.val = li.get(i);
        }

        i++;

        helper(root.right, li);
    }

}