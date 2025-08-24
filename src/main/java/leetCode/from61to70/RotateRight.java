package leetCode.from61to70;

import ob.ListNode;

class RotateRight {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        int real = k % length;
        if (real == 0) return head;
        int step = length - real;
        cur = head;
        ListNode newhead = null;
        while (--step > 0) {
            cur = cur.next;
        }
        newhead = cur.next;
        cur.next = null;
        cur = newhead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newhead;
    }
}