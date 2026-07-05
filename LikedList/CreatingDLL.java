class Node {
    int data;
    Node next;
    Node prev;

    Node(int data1, Node next1, Node prev1) {
        data = data1;
        next = next1;
        prev = prev1;
    }

    Node(int data1) {
        data = data1;
        next = null;
        prev = null;
    }
}

public class CreatingDLL {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 7 };

        Node y = new Node(arr[0]);

        // Address
        System.out.println(y);

        // Link
        System.out.println(y.next);

        System.out.println(y.prev);

        // Data
        System.out.println(y.data);
    }
}