package leetCode.from91to100;

import ob.ListNode;

class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode extra = new ListNode();
        extra.next = head;
        ListNode cur = extra;
        ListNode prev, Left, Right, Next;
        int index = 0;
        while (index < left - 1) {
            cur = cur.next;
            index++;
        }
        prev = cur;
        Left = cur.next;
        while (index < right) {
            cur = cur.next;
            index++;
        }
        Right = cur;
        Next = cur.next;

        cur = Left;
        ListNode N = cur.next;
        while (left++ < right) {
            ListNode tmp = N.next;
            N.next = cur;
            cur = N;
            N = tmp;
        }
        prev.next = Right;
        Left.next = Next;
        return extra.next;
    }

    public static void main(String[] args) {
        ReverseBetween obj = new ReverseBetween();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        obj.reverseBetween(head, 1, 4);
    }
}