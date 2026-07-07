import java.util.Arrays;
import java.util.List;

class ListNode {
    int data;

    ListNode next;

    ListNode(int data1, ListNode next1) {
        data = data1;
        next = next1;
    }

    ListNode(int data1) {
        data = data1;
        next = null;
    }
}

public class RemoveNthNodeFromBack {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));

        head = deleteNthNodeFromEndOptimal(head, N);

        printLL(head);
    }

    public static Node deleteNthNodeFromEndOptimal(Node head, int N) {

        if (head == null || head.next == null)
            return null;

        Node fast = head;
        Node slow = head;

        for (int i = 0; i <= N; i++) {
            fast = fast.next;
        }

        if (fast == null)
            return head.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static Node deleteNthNodeFromEnd(Node head, int N) {
        if (head == null) {
            return null;
        }

        int cnt = 0;
        Node temp = head;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        if (cnt == N) {
            return head.next;
        }

        int res = cnt - N;
        temp = head;

        while (temp != null) {
            res--;
            if (res == 0) {
                break;
            }
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
