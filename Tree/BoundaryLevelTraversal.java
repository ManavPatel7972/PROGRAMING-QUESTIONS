import java.util.ArrayList;
import java.util.List;

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

public class BoundaryLevelTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        List<Integer> result = printBoundary(root);

        System.out.print("Boundary Traversal: ");

        for (int val : result) {
            System.out.print(val + " ");
        }

        System.out.println();

    }

    public static List<Integer> printBoundary(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        if (!isLeaf(root))
            res.add(root.data);

        addLeftBoundary(root, res);
        addLeafs(root, res);
        addRightBoundary(root, res);

        return res;
    }

    private static boolean isLeaf(Node root) {
        return root.left == null && root.right == null;
    }

    private static void addLeftBoundary(Node root, List<Integer> res) {
        Node curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    private static void addLeafs(Node root, List<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null)
            addLeafs(root.left, res);

        if (root.right != null)
            addLeafs(root.right, res);

    }

    private static void addRightBoundary(Node root, List<Integer> res) {

        Node curr = root.right;

        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }

    }
}
