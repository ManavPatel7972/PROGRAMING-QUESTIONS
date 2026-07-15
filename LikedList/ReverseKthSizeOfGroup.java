class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class ReverseKthSizeOfGroup {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = reverseKGroup(head, k);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode groupPrev = null;

        while (temp != null) {
            ListNode kthNode = findKthNode(temp, k);

            if (kthNode == null) {
                if (groupPrev != null) {
                    groupPrev.next = temp;
                }
                break;
            }

            ListNode groupNext = kthNode.next;
            kthNode.next = null;
            ListNode newHead = reverse(temp);

            if (groupPrev == null) {
                head = kthNode;
            } else {
                groupPrev.next = kthNode;
            }

            groupPrev = temp;
            temp = groupNext;

        }

        return head;

    }

    public static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextNode;
        }

        return pre;
    }

    public static ListNode findKthNode(ListNode curr, int k) {

        k--;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }

        return curr;
    }

}
