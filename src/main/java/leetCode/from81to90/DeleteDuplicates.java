package leetCode.from81to90;



class DeleteDuplicates {
     // https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/ 82
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        ListNode tail = newHead;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
                continue;
            }
            if (cur.val != cur.next.val) {
                tail.next = cur;
                tail = cur;
                cur = cur.next;
                continue;
            }
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (cur.next == null) {
                tail.next = null;
                break;
            }
            cur = cur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode(5);
        ListNode n6 = new ListNode(4, n7);
        ListNode n5 = new ListNode(4, n6);
        ListNode n4 = new ListNode(3, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode head = d.deleteDuplicates(n1);
    }
}