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

public class IterativePreOrder {
    public static void main(String[] args) {

    }

    public List<Integer> preOrder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Stack<Node> st = new Stack<>();

        st.push(root);

        while (!st.isEmpty()) {
            root = st.pop();
            ans.add(root.val);

            if (root.right != null)
                st.push(root.right);

            if (root.left != null)
                st.push(root.left);

        }

        return ans;
    }
}
