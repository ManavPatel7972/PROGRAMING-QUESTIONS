import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int data;
    Node next;
    Node child;

    Node() {
        data = 0;
        next = child = null;
    }

    Node(int val) {
        data = val;
        next = null;
        child = null;
    }

    Node(int val, Node next1, Node child1) {
        data = val;
        next = next1;
        child = child1;
    }
}

public class FlatteningALinkedList {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.child = new Node(14);

        head.next = new Node(10);
        head.next.child = new Node(41);

        head.next.next = new Node(12);
        head.next.next.child = new Node(13);
        head.next.next.child.child = new Node(20);

        head.next.next.next = new Node(7);
        head.next.next.next.child = new Node(17);

        System.out.println("Original linked list:");

        Node flattened = flattenLinkedListOptimal(head);
        System.out.print("\nFlattened linked list: ");
        printLinkedList(flattened);
    }

    public static Node flattenLinkedListOptimal(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mergeNode = flattenLinkedListOptimal(head.next);

        return merge(head, mergeNode);
    }

    public static Node merge(Node h1, Node h2) {
        Node dummy = new Node(-1);
        Node res = dummy;

        while (h1 != null && h2 != null) {
            if (h1.data < h2.data) {
                res.child = h1;
                h1 = h1.child;
            } else {
                res.child = h2;
                h2 = h2.child;
            }

            res = res.child;
            res.next = null;
        }

        if (h1 != null)
            res.child = h1;

        else
            res.child = h2;

        return dummy.child;

    }

    // ===============================================================

    public static Node flattenLinkedList(Node head) {
        List<Integer> arr = new ArrayList<>();

        while (head != null) {
            Node t2 = head;
            while (t2 != null) {
                arr.add(t2.data);
                t2 = t2.child;
            }

            head = head.next;
        }

        Collections.sort(arr);

        return convert(arr);
    }

    public static Node convert(List<Integer> arr) {
        Node dummy = new Node(-1);
        Node temp = dummy;

        for (int i : arr) {
            temp.child = new Node(i);
            temp = temp.child;
        }

        return dummy.child;
    }

    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }

        System.out.println();
    }
}
