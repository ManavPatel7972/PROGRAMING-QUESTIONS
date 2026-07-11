class Node {
    int data;
    Node next;
    Node prev;

    public Node(int val) {
        data = val;
        prev = null;
        next = null;
    }
}

public class RemoveDuplicatesFromSortedDLL {
    public static void main(String[] args) {
        Node[] headRef = new Node[1];

        insertAtEnd(headRef, 1);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 3);
        insertAtEnd(headRef, 3);
        insertAtEnd(headRef, 4);
        insertAtEnd(headRef, 5);

        System.out.println("Original List:");
        printList(headRef[0]);

        Node head = removeDuplicates(headRef[0]);
        System.out.println("After :");
        printList(head);
    }

    public static Node removeDuplicates(Node head) {
        if (head == null)
            return null;

        Node current = head;

        while (current != null && current.next != null) {
            Node nextDistinct = current.next;

            while (nextDistinct != null && nextDistinct.data == current.data) {
                nextDistinct = nextDistinct.next;
            }

            current.next = nextDistinct;

            if (nextDistinct != null) {
                nextDistinct.prev = current;
            }

            current = current.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null)
                System.out.print(" <-> ");

            temp = temp.next;
        }

        System.out.println();
    }

    public static void insertAtEnd(Node[] headRef, int val) {
        Node newNode = new Node(val);

        if (headRef[0] == null) {
            headRef[0] = newNode;
            return;
        }

        Node temp = headRef[0];

        while (temp.next != null) {
            temp = temp.next;

        }

        temp.next = newNode;
        newNode.prev = temp;
    }

}
