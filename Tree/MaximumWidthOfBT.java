import java.util.LinkedList;
import java.util.Queue;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    Node node;
    int idx;

    Pair(Node node, int idx) {
        this.node = node;
        this.idx = idx;
    }
}

public class MaximumWidthOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        System.out.println("Maximum width: " + maxWidth(root));
    }

    public static int maxWidth(Node root) {

        if (root == null)
            return 0;

        int maxWidth = 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            // Get the minimum index at this level
            int minIndex = q.peek().idx;

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {

                Pair temp = q.poll();
                Node node = temp.node;
                int currIndex = temp.idx - minIndex;

                if (i == 0) {
                    first = currIndex;
                }

                if (i == size - 1) {
                    last = currIndex;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * currIndex + 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * currIndex + 2));
                }
            }

            maxWidth = Math.max(maxWidth, last - first + 1);

        }

        return maxWidth;
    }

}