
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

class Solution {

    public void preorder(Node root, java.util.List<Integer> arr) {

        if (root == null) {
            return;
        }

        arr.add(root.data);

        preorder(root.left, arr);

        preorder(root.right, arr);
    }

    public java.util.List<Integer> preOrder(Node root) {

        java.util.List<Integer> arr = new java.util.ArrayList<>();

        preorder(root, arr);

        return arr;
    }
}

public class PreOrder {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sol = new Solution();
        java.util.List<Integer> result = sol.preOrder(root);

        System.out.print("Preorder Traversal: ");

        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}