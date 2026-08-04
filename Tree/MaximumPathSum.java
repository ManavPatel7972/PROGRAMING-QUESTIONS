class Node {
    int val;
    Node left, right;

    Node(int x) {
        val = x;
    }
}

public class MaximumPathSum {

    public static int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println("Maximum Path Sum: " + maxPathSum(root));
    }

    public static int maxPathSum(Node root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(Node root) {
        if (root == null)
            return 0;

        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));

        maxSum = Math.max(maxSum, l + r + root.val);

        return Math.max(l, r) + root.val;
    }
}
