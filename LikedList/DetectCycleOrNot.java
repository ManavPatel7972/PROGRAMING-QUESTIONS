import java.util.HashMap;
import java.util.Map;

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

public class DetectCycleOrNot {
    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        // fifth.next = third;

        System.out.println();

        if (detectLoopOptimal(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }

    public static boolean detectLoopBrute(Node head) {

        Node temp = head;
        Map<Node, Integer> m = new HashMap<>();

        while (temp != null) {
            if (m.containsKey(temp)) {
                return true;
            }

            m.put(temp, 1);
            temp = temp.next;
        }

        return false;
    }

    public static boolean detectLoopOptimal(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }
}
