class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class CreatingALinkedList {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 7 };

        Node y = new Node(arr[0]);

        // Address
        System.out.println(y);

        // Link
        System.out.println(y.next);

        // Data
        System.out.println(y.data);
    }
}