import java.util.ArrayList;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
    }
}

public class FindPairsWithGivenSumDLL {

    public static void main(String[] args) {

        Node head = null;

        head = insert(head, 1);
        head = insert(head, 2);
        head = insert(head, 4);
        head = insert(head, 5);
        head = insert(head, 6);
        head = insert(head, 8);
        head = insert(head, 9);

        // printList(head);

        int target = 7;

        ArrayList<ArrayList<Integer>> ans = findPairs(head, target);

        System.out.println(ans);
    }

    public static ArrayList<ArrayList<Integer>> findPairs(Node head, int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (head == null)
            return ans;

        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        Node left = head;

        while (left != null && right != null &&
                left != right &&
                left.prev != right) {

            int sum = left.data + right.data;

            if (sum == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                ans.add(pair);

                left = left.next;
                right = right.prev;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }

        return ans;
    }

    public static Node insert(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null)
            return newNode;

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;

        return head;
    }

    public static void printList(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }
}