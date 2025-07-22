package from81to90;

class DeleteDuplicates2 {
    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list/ 83
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head;
        ListNode tail = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == tail.val) {
                cur = cur.next;
            } else {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
            }
        }
        tail.next = null;
        return newHead;
    }
}