
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
    }

}

class Pair {
    Node node;
    int vertical_level;

    Pair(Node node, int vertical_level) {
        this.node = node;
        this.vertical_level = vertical_level;
    }
}

public class TopViewOfBT {
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

        List<Integer> res = topView(root);
        System.out.print("Top View Traversal: ");
        for (int val : res) {
            System.out.print(val + " ");
        }

    }

    public static List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        helperLeft(root, ans);
        helperRight(root.right, ans);

        return ans;
    }

    private static void helperLeft(Node root, List<Integer> ans) {

        if (root == null)
            return;

        helperLeft(root.left, ans);
        ans.add(root.data);

    }

    private static void helperRight(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        helperRight(root.right, ans);
        ans.add(root.data);
    }

    public static List<Integer> topViewLevelOrder(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // Map to store vertical level -> node value (only first encountered)
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue storing {node, vertical_level}
        Queue<Pair> q = new LinkedList<>();

        // Push the root node with vertical level 0
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            Node node = p.node;
            int line = p.vertical_level;

            if (!map.containsKey(line)) {
                map.put(line, node.data);
            }

            if (node.left != null) {
                q.add(new Pair(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair(node.right, line + 1));
            }
        }

        for (int val : map.values()) {
            ans.add(val);
        }

        return ans;
    }

}
