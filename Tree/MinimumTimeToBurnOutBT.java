import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class MinimumTimeToBurnOutBT {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);

        int target = 1;
        System.out.println("Minimum time to burn the tree: " + minTime(root, target));
    }

    public static int minTime(Node root, int target) {
        if (root == null)
            return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        Node n = makeParent(root, parentMap, target);

        return helper(n, parentMap);

    }

    private static Node makeParent(Node root, Map<Node, Node> parentMap, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node res = new Node(-1);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.data == target) {
                res = node;
            }

            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parentMap.put(root.right, node);
                q.add(node.right);
            }
        }

        return res;
    }

    private static int helper(Node target, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.add(target);

        Set<Node> vis = new HashSet<>();
        vis.add(target);

        int time = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            int flag = 0;

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                if (node.left != null && !vis.contains(node.left)) {
                    flag = 1;
                    vis.add(node.left);
                    q.add(node.left);
                }

                if (node.right != null && !vis.contains(node.right)) {
                    flag = 1;
                    vis.add(node.right);
                    q.add(node.right);
                }

                if (parentMap.containsKey(node) && !vis.contains(parentMap.get(node))) {
                    flag = 1;
                    vis.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }

            }

            if (flag == 1)
                time++;

        }

        return time;

    }
}