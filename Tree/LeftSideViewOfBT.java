import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;

    }
}

public class LeftSideViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> li = leftSideViewOptimal(root);

        System.out.println(li.toString());
    }

    public static List<Integer> leftSideView(Node root) {
        List<List<Integer>> lo = new ArrayList<>();

        List<Integer> left = new ArrayList<>();

        if (root == null)
            return left;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                level.add(node.data);

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }

            lo.add(level);
        }

        // left side view
        for (List<Integer> li : lo) {
            left.add(li.get(0));
        }

        return left;
    }

    public static List<Integer> leftSideViewOptimal(Node root) {
        List<Integer> left = new ArrayList<>();

        if (root == null)
            return left;

        helper(root, left, 0);

        return left;
    }

    private static void helper(Node root, List<Integer> left, int level) {
        if (root == null)
            return;

        if (left.size() == level) {
            left.add(root.data);
        }

        helper(root.left, left, level + 1);
        helper(root.right, left, level + 1);
    }
}
