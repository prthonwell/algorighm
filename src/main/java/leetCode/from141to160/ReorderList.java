package leetCode.from141to160;

import ob.ListNode;

class ReorderList {
    public void reorderList(ListNode head) {
        ListNode left = head;
        if (left.next == null) return;
        ListNode next, temp, right, cur;
        int count = 0;
        while (left != null) {
            count = count + 1;
            left = left.next;
        }
        int startPos = --count / 2;
        left = head.next;
        while (startPos-- > 0) {
            left = left.next;
        }
        next = left.next;
        left.next = null;
        while (next != null) {
            temp = next.next;
            next.next = left;
            left = next;
            next = temp;
        }
        right = left;
        left = head.next;
        cur = head;
        while (right != left) {
            if (right.next == null) {
                cur.next = right;
                right.next = left;
                left.next = null;
                break;
            }
            temp = right.next;
            cur.next = right;
            right.next = left;
            cur = left;
            right = temp;
            left = left.next;
        }
    }

    public static void main(String[] args) {
        ReorderList r = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        r.reorderList(head);
    }
}