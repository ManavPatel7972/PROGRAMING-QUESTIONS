import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        data = x;
        left = null;
        right = null;
    }
}

class Solution {

    public List<Integer> inorder(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        List<Integer> inorder = new ArrayList<>();

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }
}

public class InOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution sol = new Solution();

        List<Integer> result = sol.inorder(root);

        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}