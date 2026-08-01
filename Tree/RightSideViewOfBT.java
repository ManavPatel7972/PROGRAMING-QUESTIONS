import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int val) {
        data = val;
        left = right = null;
    }
}

public class RightSideViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.right = new Node(5);

        List<Integer> ans = rightSideViewOptimal(root);

        System.out.println(ans.toString());
    }

    public static List<Integer> rightSideView(Node root) {
        List<List<Integer>> lo = new ArrayList<>();

        List<Integer> right = new ArrayList<>();

        if (root == null)
            return right;

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

        for (List<Integer> li : lo) {
            right.add(li.get(li.size() - 1));
        }

        return right;
    }

    public static List<Integer> rightSideViewOptimal(Node root) {
        List<Integer> right = new ArrayList<>();
        if (root == null)
            return right;

        helper(root, right, 0);

        return right;
    }

    private static void helper(Node root, List<Integer> right, int level) {
        if (root == null)
            return;

        if (right.size() == level) {
            right.add(root.data);
        }

        helper(root.right, right, level + 1);
         helper(root.left, right, level + 1);
    }

}
