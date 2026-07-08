import java.util.Stack;

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

public class PalindromeLLOrNot {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        // head.next.next.next.next.next = new ListNode(1);

        if (isPalindromeOptimal(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }

    }

    public static boolean isPalindromeBrute(ListNode head) {
        Stack<Integer> st = new Stack<>();

        ListNode tListNode = head;
        while (tListNode != null) {
            st.push(tListNode.data);
            tListNode = tListNode.next;
        }

        tListNode = head;

        while (!st.isEmpty()) {
            if (st.pop() != tListNode.data)
                return false;

            tListNode = tListNode.next;
        }

        return true;
    }

    public static boolean isPalindromeOptimal(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow.next);

        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.data != second.data) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverse(newHead);
        return true;

    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

}
