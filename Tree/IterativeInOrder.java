import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int val;
    Node left;
    Node right;

    public Node(int data) {
        val = data;
        left = null;
        right = null;
    }
}

public class IterativeInOrder {
    public static void main(String[] args) {

    }

    public List<Integer> inOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<Node> st = new Stack<>();

        Node node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            }

            else {
                if (st.isEmpty()) {
                    break;
                }

                node = st.pop();
                ans.add(node.val);
                node = node.right;
            }
        }

        return ans;

    }
}
