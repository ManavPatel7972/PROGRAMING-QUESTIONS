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

public class DeleteAllOccurrencesOfKeyInDLL {
    public static void main(String[] args) {
        Node[] headRef = new Node[1];

        insertAtEnd(headRef, 1);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 3);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 4);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 5);

        System.out.println("Original List:");
        printList(headRef[0]);

        Node head = deleteTargetNodes(headRef[0], 2);
        System.out.println("After :");
        printList(head);
    }

    public static Node deleteTargetNodes(Node head, int target) {
        if (head == null)
            return null;

        Node temp = head;

        Node dummy = new Node(-1);

        Node itr = null;

        while (temp != null) {

            if (temp.data != target) {
                Node newNode = new Node(temp.data);

                if (itr == null) {
                    dummy.next = newNode;
                    newNode.prev = dummy;
                    itr = newNode;
                } else {
                    itr.next = newNode;
                    newNode.prev = itr;
                    itr = newNode;
                }
            }

            temp = temp.next;
        }

        Node t = dummy.next;

        if (t != null)
            t.prev = null;

        return t;
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