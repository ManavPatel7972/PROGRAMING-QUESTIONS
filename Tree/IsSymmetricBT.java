class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class IsSymmetricBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.right.right = new Node(3);
        root.left.right = new Node(4);
        // root.right.left = new Node(4);

        if (isSymmetric(root)) {
            System.out.println("This Tree is Symmetrical");
        } else {
            System.out.println("This Tree is NOT Symmetrical");
        }
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        return helper(root.left, root.right);
    }

    private static boolean helper(Node root1, Node root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null) {
            return false;
        }

        return (root1.data == root2.data) && (helper(root1.left, root2.right)) && (helper(root1.right, root2.left));
    }
}