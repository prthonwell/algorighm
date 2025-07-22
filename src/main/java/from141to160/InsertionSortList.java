package from141to160;

import ob.ListNode;

class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode Prev = new ListNode(-5001);
        Prev.next = head;
        ListNode PreHead = Prev;
        Prev = head;
        ListNode Curr;
        while (Prev.next != null) {
            ListNode c = Prev.next;
            ListNode temp = c.next;
            int val = c.val;
            if (val < Prev.val) {
                Curr = PreHead;
                while (Curr.next.val <= val) {
                    Curr = Curr.next;
                }
                ListNode temp2 = Curr.next;
                Curr.next = c;
                c.next = temp2;
                Prev.next = temp;
            } else {
                Prev = Prev.next;
            }
        }
        return PreHead.next;
    }
}