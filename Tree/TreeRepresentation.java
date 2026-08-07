
class Node {
    int data;
    Node left;
    Node right;

    public Node(int key) {
        data = key;
        left = null;
        right = null;
    }
}

class Solution {
    public Node createBinaryTree() {

        Node root = new Node(1);

        root.left = new Node(2);

        root.right = new Node(3);

        root.right.left = new Node(5);

        return root;
    }
}

public class TreeRepresentation {
    public static void main(String[] args) {
        // Solution solution = new Solution();
        // Node root = solution.createBinaryTree();
    }
}