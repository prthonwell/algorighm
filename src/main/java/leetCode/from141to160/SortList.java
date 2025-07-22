package leetCode.from141to160;

import ob.ListNode;

class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int Len = 0;
        ListNode fast = head;
        while (fast != null) {
            Len++;
            fast = fast.next;
        }
        return sort(head, Len);
    }

    private ListNode sort(ListNode head, int Len) {
        if (Len == 1) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        int i = (Len + 1) / 2;
        while (i-- > 0) {
            slow = slow.next;
        }
        ListNode Left = sort(head, (Len+1) / 2);
        ListNode Right = sort(slow, Len / 2);
        ListNode newHead = new ListNode(0);
        ListNode result = newHead;
        while (Left != null && Right != null) {
            if (Left.val < Right.val) {
                result.next = Left;
                Left = Left.next;
            } else {
                result.next = Right;
                Right = Right.next;
            }
            result = result.next;
        }
        if (Left != null) {
            result.next = Left;
        } else{
            result.next = Right;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        SortList sortList = new SortList();
        ListNode result = sortList.sortList(head);
    }
}