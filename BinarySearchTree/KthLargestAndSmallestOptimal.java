package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

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

class Solution {
    private int k;
    private int result;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            if (--k == 0) {
                result = root.data;
                return;
            }
            inOrder(root.right);
        }
    }

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        reverseInOrder(root);
        return result;
    }

    public void reverseInOrder(TreeNode root) {
        if (root != null) {
            reverseInOrder(root.right);
            if (--k == 0) {
                result = root.data;
                return;
            }
            reverseInOrder(root.left);
        }
    }

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        result.add(kthSmallest(root, k));
        result.add(kthLargest(root, k));
        return result;
    }
}

public class KthLargestAndSmallestOptimal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        Solution solution = new Solution();
        int k = 1;
        List<Integer> result = solution.kLargesSmall(root, k);

        System.out.println(result);
    }
}
