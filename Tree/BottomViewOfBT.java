import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

class Pair {
    Node node;
    int vertical_line;

    Pair(Node node, int vertical_line) {
        this.node = node;
        this.vertical_line = vertical_line;
    }
}

public class BottomViewOfBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.right.left = new Node(9);

        List<Integer> bottomView = bottomView(root);

        System.out.println("Bottom View Traversal: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
        }

    }

    public static List<Integer> bottomView(Node root) {

        Map<Integer, Integer> map = new TreeMap<>();

        List<Integer> li = new ArrayList<>();

        if (root == null)
            return li;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair temp = q.poll();

            Node node = temp.node;
            int line = temp.vertical_line;

            map.put(line, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }

        for (int val : map.values()) {
            li.add(val);
        }

        return li;

    }
}