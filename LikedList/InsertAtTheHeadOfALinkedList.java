class Node {
    int data;
    Node next;

    Node() {
        data = 0;
        next = null;
    }

    Node(int data1) {
        data = data1;
        next = null;
    }

    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }
}

public class InsertAtTheHeadOfALinkedList {
    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(3);

        System.out.println("Original :");
        printList(head);

        head = insertAtFirst(head, 10);

        System.out.println("After");
        printList(head);
    }

    public static Node insertAtFirst(Node node, int val) {

        Node newNode = new Node(val);

        if (node == null) {
            return newNode;
        }

        newNode.next = node;
        node = newNode;
        return node;

    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
