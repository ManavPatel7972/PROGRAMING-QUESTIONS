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

public class KthLargestAndSmallest {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        int k = 1;
        List<Integer> result = kLargesSmall(root, k);

        System.out.println(result);

    }

    public static List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();

        inOrder(root, li);

        int small = li.get(k - 1);
        int large = li.get(li.size() - k);

        List<Integer> res = new ArrayList<>();
        res.add(small);
        res.add(large);

        return res;
    }

    public static void inOrder(TreeNode root, List<Integer> li) {

        if (root == null)
            return;

        inOrder(root.left, li);
        li.add(root.val);
        inOrder(root.right, li);

    }
}
