import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node random;

    Node(int val) {
        data = val;
        next = random = null;
    }

    Node() {
        data = 0;
        next = random = null;
    }

    Node(int val, Node next1, Node random1) {
        data = val;
        next = next1;
        random = random1;
    }
}

public class CloneLLWithRandomAndNextPointer {
    public static void main(String[] args) {
        // LL
        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        // Random Pointer
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
        printClonedLinkedList(head);

        Node clonedList = cloneLLOptimal(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
        printClonedLinkedList(clonedList);
    }

    public static Node cloneLL(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.data));
            temp = temp.next;
        }

        // Connect next and random pointers
        temp = head;

        while (temp != null) {
            Node copy = map.get(temp);

            copy.next = map.get(temp.next);
            copy.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }

    // ===================================================

    public static Node cloneLLOptimal(Node head) {
        // If the original list
        // is empty, return null
        if (head == null)
            return null;

        // Step 1: Insert copy of
        // nodes in between
        insertCopyInBetween(head);
        // Step 2: Connect random
        // pointers of copied nodes
        connectRandomPointers(head);
        // Step 3: Retrieve the deep
        // copy of the linked list
        return getDeepCopyList(head);
    }

    public static void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextElement = temp.next;
            // Create a new node with the same data
            Node copy = new Node(temp.data);

            // Point the copy's next to
            // the original node's next
            copy.next = nextElement;

            // Point the original
            // node's next to the copy
            temp.next = copy;

            // Move to the next original node
            temp = nextElement;
        }
    }

    public static void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            // Access the copied node
            Node copyNode = temp.next;

            // If the original node
            // has a random pointer
            if (temp.random != null) {
                // Point the copied node's random to the
                // corresponding copied random node
                copyNode.random = temp.random.next;
            } else {
                // Set the copied node's random to
                // null if the original random is null
                copyNode.random = null;
            }

            // Move to the next original node
            temp = temp.next.next;
        }
    }

    // deep copy of the linked list
    public static Node getDeepCopyList(Node head) {
        Node temp = head;
        // Create a dummy node
        Node dummyNode = new Node(-1);
        // Initialize a result pointer
        Node res = dummyNode;

        while (temp != null) {
            // Creating a new List by
            // pointing to copied nodes
            res.next = temp.next;
            res = res.next;

            // Disconnect and revert back to the
            // initial state of the original linked list
            temp.next = temp.next.next;
            temp = temp.next;
        }

        // Return the deep copy of the
        // list starting from the dummy node
        return dummyNode.next;
    }

    public static void printClonedLinkedList(Node head) {
        while (head != null) {
            System.out.print("Data: " + head.data);
            if (head.random != null) {
                System.out.print(", Random: " + head.random.data);
            } else {
                System.out.print(", Random: null");
            }

            System.out.println();
            head = head.next;
        }
    }
}
