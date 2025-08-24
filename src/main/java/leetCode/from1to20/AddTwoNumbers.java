package leetCode.from1to20;

import ob.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rest = 0;
        ListNode pre = new ListNode();
        ListNode head = pre;
        while (l1 != null || l2 != null || rest != 0) {
            int i1 = l1 == null ? 0 : l1.val;
            int i2 = l2 == null ? 0 : l2.val;
            int sum = i1 + i2 + rest;
            ListNode cur = new ListNode(sum % 10);
            rest = sum / 10;
            pre.next = cur;
            pre = cur;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }
}
