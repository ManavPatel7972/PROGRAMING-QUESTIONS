import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

public class SortLL {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 3, 5, 7, 23, 53, 67);

        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));
        head.next.next.next.next.next = new Node(arr.get(5));

        head = sortLLOptimal(head);

        printLL(head);
    }

    public static Node sortLLOptimal(Node head) {
        if (head == null || head.next == null)
            return head;

        Node middle = findMiddle(head);

        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLLOptimal(left);
        right = sortLLOptimal(right);

        return mergeTwoSortedLL(left, right);
    }

    public static Node mergeTwoSortedLL(Node l1, Node l2) {
        Node dummy = new Node(-1, null);
        Node temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return dummy.next;
    }

    public static Node findMiddle(Node head) {
        if (head == null || head.next == null)
            return head;

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node sortLL(Node head) {
        ArrayList<Integer> arr = new ArrayList<>();

        Node temp = head;

        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        Collections.sort(arr);

        temp = head;
        for (int i = 0; i < arr.size(); i++) {
            temp.data = arr.get(i);
            temp = temp.next;
        }

        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
