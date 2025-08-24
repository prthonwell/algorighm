package leetCode.from20to30;

import ob.ListNode;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        while (head != null && head.next != null) {
            ListNode next = head.next.next;
            head.next.next = head;
            prev.next = head.next;
            head.next = next;
            prev = head;
            head = next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        swapPairs.swapPairs(head);
    }
}
