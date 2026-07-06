class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class DeleteLastNodeOfLinkedList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        head = deleteTail(head);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();

        System.out.println("Len = " + lengthOfLL(head));

        System.out.println("Present = " + findInLL(head, 1));
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;
        while (curr.next.next != null) {
            curr = curr.next;
        }

        curr.next = null;

        return head;
    }

    public static int lengthOfLL(Node head) {

        int cnt = 0;

        Node temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;

        }

        return cnt;
    }

    public static boolean findInLL(Node head, int target) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == target) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

}