
class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution {

    public static java.util.List<Integer> postOrder(Node root) {
        java.util.List<Integer> postorder = new java.util.ArrayList<>();

        if (root == null) {
            return postorder;
        }

        java.util.Stack<Node> st1 = new java.util.Stack<>();
        java.util.Stack<Node> st2 = new java.util.Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);

            if (root.left != null) {
                st1.push(root.left);
            }

            if (root.right != null) {
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty()) {
            postorder.add(st2.pop().data);
        }

        return postorder;
    }
}

public class PostOrder {

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        java.util.List<Integer> result = Solution.postOrder(root);

        System.out.print("Postorder traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}