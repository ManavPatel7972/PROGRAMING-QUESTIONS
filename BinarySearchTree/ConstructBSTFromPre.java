package BinarySearchTree;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class ConstructBSTFromPre {

    static int index = 0;

    public static void main(String[] args) {
        int[] preOrder = { 8, 5, 1, 7, 10, 12 };
        Node node = bst(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println("root = " + node.data);
    }

    public static Node bst(int[] preOrder, int min, int max) {
        if (index == preOrder.length)
            return null;
    

        int val = preOrder[index];

        if (val < min || val > max)
            return null;

        Node root = new Node(val);
        index++;

        root.left = bst(preOrder, min, val - 1);
        root.right = bst(preOrder, val + 1, max);

        return root;
    
    }   

    
}
