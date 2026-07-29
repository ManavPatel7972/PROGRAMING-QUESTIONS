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

public class CheckBalancedBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        if (isBalancedOptimal(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }

    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int lh = findHeight(root.left);
        int rh = findHeight(root.right);

        if (Math.abs(rh - lh) > 1)
            return false;

        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);

        if (!l || !r)
            return false;

        return true;
    }

    public static int findHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    public static boolean isBalancedOptimal(Node root) {
        return dfsHeight(root) != -1;
    }

    public static int dfsHeight(Node root) {
        if (root == null)
            return 0;

        int lh = dfsHeight(root.left);
        if (lh == -1)
            return -1;

        int rh = dfsHeight(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(rh - lh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }
}
