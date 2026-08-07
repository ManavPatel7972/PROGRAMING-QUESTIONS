import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class SameTreeOrNot {
    public static void main(String[] args) {
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);

        if (isIdentical(root1, root2)) {
            System.out.println("The binary trees are identical.");
        } else {
            System.out.println("The binary trees are not identical.");
        }

    }

    public static boolean isIdentical(Node node1, Node node2) {

        if (node1 == null && node2 == null)
            return true;

        if (node1 == null || node2 == null)
            return false;

        return (node1.val == node2.val) && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right);
    }
}
