class Node {
    int data;
    Node next;
    Node back;

    public Node(int data1, Node next1, Node back1) {
        data = data1;
        next = next1;
        back = back1;
    }

    public Node(int data1) {
        data = data1;
        next = null;
        back = null;
    }
}

public class InsertAtTheHeadOfDLL {
    public static void main(String[] args) {
        int[] arr = { 12, 5, 8, 7, 4 };

        Node head = convertArr2DLL(arr);

        System.out.println("Doubly Linked List Initially: ");
        print(head);

        System.out.println("\nDoubly Linked List After Inserting at the tail with value 10: ");
        head = insertAtTail(head, 10);
        print(head);
    }

    public static Node insertAtTail(Node head, int k) {

        Node newNode = new Node(k);

        if (head == null) {
            return newNode;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = newNode;
        newNode.back = tail;

        return head;
    }

    public static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node deleteTail(Node head) {
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.back.next = null;

        return head;
    }
}
