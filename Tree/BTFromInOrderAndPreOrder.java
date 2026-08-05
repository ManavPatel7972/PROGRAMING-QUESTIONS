import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BTFromInOrderAndPreOrder {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        return helper(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length, inMap);
    }

    public static TreeNode helper(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {

        if (preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);

        int indexRoot = inMap.get(root.val);
        int numLeft = indexRoot - inStart;

        root.left = helper(preOrder, preStart + 1, preStart + numLeft, inOrder, inStart, indexRoot - 1, inMap);

        root.right = helper(preOrder, preStart + numLeft + 1, preEnd, inOrder, indexRoot + 1, inEnd, inMap);

        return root;

    }
}