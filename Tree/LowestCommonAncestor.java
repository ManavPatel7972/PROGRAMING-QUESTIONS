class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;

    }
}

public class LowestCommonAncestor {
    public static void main(String[] args) {

    }

    public Node lca(Node root, Node p, Node q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left == null)
            return right;
        
        if (right == null)
            return left;

        return root;
    }

}
