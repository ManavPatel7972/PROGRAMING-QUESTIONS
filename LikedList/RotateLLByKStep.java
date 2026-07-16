class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

public class RotateLLByKStep {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        int k = 2;

        Node res = rotateOptimal(head, k);

        printLL(res);

    }

    public static Node rotateBrute(Node head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        for (int i = 0; i < k; i++) {
            Node curr = head;
            Node prev = null;

            while (curr.next != null) {
                prev = curr;
                curr = curr.next;
            }

            prev.next = null;
            curr.next = head;
            head = curr;
        }

        return head;

    }

    public static Node rotateOptimal(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        Node tail = head;
        int len = 1;

        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // make circular LL
        tail.next = head;

        k = k % len;

        int step = len - k;
        Node newTail = head;

        for (int i = 1; i < step; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null;

        return newHead;

    }

    public static void printLL(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");

            temp = temp.next;
        }
        System.out.println();
    }
}
