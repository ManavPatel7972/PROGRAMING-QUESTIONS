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

public class DiameterOfTree {

    public static int dia = 0;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

    public static int diameterOfBinaryTree(Node root) {
        calculateHeight(root);
        return dia;
    }

    public static int calculateHeight(Node root) {
        if (root == null)
            return 0;

        int lh = calculateHeight(root.left);
        int rh = calculateHeight(root.right);

        dia = Math.max(dia, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
