import java.util.Arrays;
import java.util.List;

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

public class RemoveMiddleOfLL {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6);

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));
        head.next.next.next.next.next = new Node(arr.get(5));

        head = deleteMiddleOptimal(head);

        printLL(head);
    }

    public static Node deleteMiddleBrute(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int res = n / 2;
        temp = head;

        while (temp != null) {
            res--;
            if (res == 0) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }

        return head;

    }

    public static Node deleteMiddleOptimal(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        fast = fast.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
