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

public class BTFromInOrderAndPostOrder {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] postOrder, int[] inOrder) {
        
        if (postOrder.length != inOrder.length)
            return null;

        Map<Integer, Integer> inMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i], i);
        }

        return helper(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length, inMap);
    }

    public static TreeNode helper(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {

        if (postStart > postEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postOrder[postEnd]);

        int indexRoot = inMap.get(root.val);
        int numLeft = indexRoot - inStart;

        root.left = helper(postOrder, postStart, postStart + numLeft -1, inOrder, inStart, indexRoot - 1, inMap);

        root.right = helper(postOrder, postStart + numLeft,  postEnd , inOrder, indexRoot + 1, inEnd, inMap);

        return root;

    }
}
