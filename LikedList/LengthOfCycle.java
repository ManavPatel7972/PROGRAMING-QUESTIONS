import java.util.HashMap;

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

public class LengthOfCycle {
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

        System.out.println("Length = " + lengthOfCycle(head));

    }

    public static int lengthOfCycle(Node head) {
        Node temp = head;
        HashMap<Node, Integer> map = new HashMap<>();

        int cnt = 0;

        while (temp != null) {
            if (map.containsKey(temp)) {
                return cnt - map.get(temp);
            }

            map.put(temp, cnt);
            temp = temp.next;
            cnt++;
        }

        return 0;
    }

    public static int lengthOfCycleOptimal(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLoopLen(slow);
            }
        }

        return 0;
    }

    public static int countLoopLen(Node t) {
        Node temp = t;
        int len = 1;

        while (temp.next != t) {
            temp = temp.next;
            len++;
        }
        return len;
    }
}
