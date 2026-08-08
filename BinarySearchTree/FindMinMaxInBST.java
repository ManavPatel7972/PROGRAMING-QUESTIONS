package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class FindMinMaxInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        List<Integer> res = minMaxInBST(root);

        System.out.println("Min = " + res.get(0));
        System.out.println("Max = " + res.get(1));

    }

    public static List<Integer> minMaxInBST(TreeNode root) {
        List<Integer> li = new ArrayList<>();

        if (root == null)
            return li;

        TreeNode min = root;
        while (min.left != null) {
            min = min.left;
        }

        TreeNode max = root;
        while (max.right != null) {
            max = max.right;
        }

        li.add(min.val);
        li.add(max.val);

        return li;

    }
}
