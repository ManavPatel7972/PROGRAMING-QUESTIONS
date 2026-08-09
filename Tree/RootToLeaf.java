import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class RootToLeaf {
    public static void main(String[] args) {

    }

    public static List<Integer> rootToLeaf(Node root, int x) {
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        helper(root, ans, x);

        return ans;
    }

    private static boolean helper(Node root, List<Integer> ans, int x) {
        if (root == null)
            return false;

        ans.add(root.data);

        if (root.data == x) {
            return true;
        }

        if (helper(root.left, ans, x) || helper(root.right, ans, x)) {
            return true;
        }

        ans.remove(ans.size() - 1);

        return false;
    }
}
