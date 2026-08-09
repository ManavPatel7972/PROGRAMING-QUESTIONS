import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }

}

public class PrintNodeWithDistanceK {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(5);
        root.right = new Node(1);
        root.left.left = new Node(6);
        root.left.right = new Node(2);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(4);
        root.right.left = new Node(0);
        root.right.right = new Node(8);

        Node target = root.left;
        int k = 2;

        List<Integer> result = distanceK(root, target, k);

        System.out.println("Ans = " + result.toString());
    }

    public static List<Integer> distanceK(Node root, Node target, int k) {
        if (root == null)
            return new ArrayList<>();

        // <Node,ParentNode>
        Map<Node, Node> parentMap = new HashMap<>();

        makeParent(root, parentMap);

        return bfsFromTarget(target, parentMap, k);
    }

    private static void makeParent(Node root, Map<Node, Node> parentMap) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            // left child parent
            if (node.left != null) {
                parentMap.put(node.left, node);
                q.add(node.left);
            }

            // right child parent
            if (node.right != null) {
                parentMap.put(node.right, node);
                q.add(node.right);
            }

        }

    }

    private static List<Integer> bfsFromTarget(Node target, Map<Node, Node> parentMap, int k) {

        Queue<Node> q = new LinkedList<>();
        q.add(target);

        Set<Node> vis = new HashSet<>();
        vis.add(target);

        int currLevel = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            if (currLevel++ == k) {
                break;
            }

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                // left add
                if (node.left != null && !vis.contains(node.left)) {
                    vis.add(node.left);
                    q.add(node.left);
                }

                // right add
                if (node.right != null && !vis.contains(node.right)) {
                    vis.add(node.right);
                    q.add(node.right);
                }

                // parent add
                if (parentMap.containsKey(node) && !vis.contains(parentMap.get(node))) {
                    vis.add(parentMap.get(node));
                    q.add(parentMap.get(node));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            ans.add(q.poll().data);
        }

        return ans;
    }
}
