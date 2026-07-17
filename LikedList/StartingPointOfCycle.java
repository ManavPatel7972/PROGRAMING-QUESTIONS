import java.util.HashSet;
import java.util.Set;

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

public class StartingPointOfCycle {
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
        fifth.next = third;

        System.out.println();

        Node startNode = detectCycleNodeOptimal(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.data);
        else
            System.out.println("No cycle found.");
    }

    public static Node detectCycle(Node head) {
        Node temp = head;

        Set<Node> s = new HashSet<>();

        while (temp != null) {
            if (s.contains(temp))
                return temp;

            s.add(temp);
            temp = temp.next;
        }

        return null;

    }

    public static Node detectCycleNodeOptimal(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
            }
        }

        return null;
    }
}
