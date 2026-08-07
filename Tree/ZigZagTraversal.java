import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int data;
    Node right, left;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class ZigZagTraversal {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();

            Integer[] level = new Integer[size];

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                int index = leftToRight ? i : size - 1 - i;
                level[index] = node.data;

                if (node.left != null)
                    q.offer(node.left);

                if (node.right != null)
                    q.offer(node.right);
            }

            leftToRight = !leftToRight;

            result.add(Arrays.asList(level));
        }

        return result;
    }
}
