import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class FlattenBTtoLL {

    public static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(8);

        System.out.print("Binary Tree Preorder: ");
        printPreorder(root);
        System.out.println();

        flatten(root);

        System.out.print("Binary Tree After Flatten: ");
        printFlattenTree(root);
        System.out.println();
    }

    public static void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void flatten(TreeNode root) {
        if (root == null)
            return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void printFlattenTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printFlattenTree(root.right);
    }

    public static void flattenUsingStack(TreeNode root) {
        if (root == null)
            return;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (!st.isEmpty()) {
            TreeNode curr = st.pop();
            if (curr.right != null)
                st.push(curr.right);
            if (curr.left != null)
                st.push(curr.left);
            if (!st.isEmpty())
                curr.right = st.peek();
            curr.left = null;
        }
    }
}
