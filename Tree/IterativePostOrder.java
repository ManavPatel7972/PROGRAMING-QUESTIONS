import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class IterativePostOrder {
    public static void main(String[] args) {

    }

    public static List<Integer> postOrder(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        st1.push(root);

        while (!st1.isEmpty()) {
            root = st1.pop();
            st2.push(root);

            if (root.left != null) {
                st1.push(root.left);
            }

            if (root.right != null) {
                st1.push(root.right);
            }
        }

        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }

        return ans;
    }
}
