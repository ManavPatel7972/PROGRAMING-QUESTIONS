class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

}

public class PartitionList {
    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;

        ListNode lessDummy = new ListNode(-1);
        ListNode greaterDummy = new ListNode(-1);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        while (head != null) {

            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        less.next = greaterDummy.next;
        greater.next = null;

        return lessDummy.next;
    }

}