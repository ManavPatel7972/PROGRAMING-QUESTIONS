class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

public class Add1ToLL {
    public static void main(String[] args) {
        Node head = new Node(9);
        head.next = new Node(9);
        head.next.next = new Node(9);
        // head.next.next.next = new Node(5);
        // head.next.next.next.next = new Node(1);
        // head.next.next.next.next.next = new Node(1);

        head = add1ToLLRecursive(head);

        printList(head);
    }

    public static Node add1ToLL(Node head) {
        head = rev(head);

        Node temp = head;
        int carry = 1;

        while (temp != null) {
            temp.data = temp.data + carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }

            temp = temp.next;
        }

        if (carry == 1) {
            Node newNode = new Node(carry);
            head = rev(head);
            newNode.next = head;
            return newNode;
        }

        return rev(head);
    }

    public static Node rev(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }

    public static Node add1ToLLRecursive(Node head) {

        int carry = helper(head);
        
        if (carry == 1) {
            Node newNode = new Node(carry);
            newNode.next = head;
            return newNode;
        }

        return head;
    }

    public static int helper(Node head) {
        if (head == null)
            return 1;

        int carry = helper(head.next);
        head.data = head.data + carry;

        if (head.data < 10) {
            return 0;
        }
        head.data = 0;
        return 1;
    }
}
