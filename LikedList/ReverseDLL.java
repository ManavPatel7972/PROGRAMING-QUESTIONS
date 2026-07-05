import java.util.Stack;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        data = data1;
        next = next1;
        back = back1;
    }

    Node(int data1) {
        data = data1;
        next = null;
        back = null;
    }
}

public class ReverseDLL {
    public static void main(String[] args) {
        int[] arr = { 12, 5, 8, 7, 4 };

        Node head = convertArr2DLL(arr);

        System.out.println("Doubly Linked List Initially:");
        print(head);

        head = reverseDLLOptimal(head);

        System.out.println("\nDoubly Linked List After Reversing:");
        print(head);
    }

    public static Node reverseDLLBrute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<Integer> s = new Stack<>();

        Node temp = head;

        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            temp.data = s.pop();
            temp = temp.next;
        }

        return head;
    }

    public static Node reverseDLLOptimal(Node head) {
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = curr.back;
            curr.back = temp;

            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);

        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

}
