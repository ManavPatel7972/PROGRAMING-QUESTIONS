import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class SerializeDeserializeBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.print("Original Tree: ");
        inOrder(root);
        System.out.println();

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);

        System.out.print("Tree after Deserialisation: ");
        inOrder(deserialized);
        System.out.println();

    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }

    public static String serialize(TreeNode root) {
        if (root == null)
            return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder s = new StringBuilder();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr != null) {
                s.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            } else {
                s.append("#").append(",");
            }
        }

        return s.toString();
    }

    public static TreeNode deserialize(String s) {
        if (s.isEmpty())
            return null;

        String[] val = s.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(val[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < val.length) {

            TreeNode node = q.poll();

            if (!val[i].equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(val[i]));
                node.left = leftNode;
                q.add(leftNode);
            }

            i++;

            if (!val[i].equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(val[i]));
                node.right = rightNode;
                q.add(rightNode);
            }

            i++;
        }

        return root;

    }
}
