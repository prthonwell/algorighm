package from81to90;

class Partition {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode smallHead, smallTail, bigHead, bigTail;
        if (head.val < x) {
            smallHead = head;
            smallTail = head;
            head = head.next;
            while (head != null && head.val < x) {
                head = head.next;
                smallTail = smallTail.next;
            }
            if (head == null) {
                return smallHead;
            }
            bigHead = head;
            bigTail = head;
        } else {
            bigHead = head;
            bigTail = head;
            head = head.next;
            while (head != null && head.val >= x) {
                head = head.next;
                bigTail = bigTail.next;
            }
            if (head == null) {
                return bigHead;
            }
            smallHead = head;
            smallTail = head;
        }
        head = head.next;
        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }
            head = head.next;
        }
        smallTail.next = bigHead;
        bigTail.next = null;
        return smallHead;
    }

    public static void main(String[] args) {
        ListNode n6 = new ListNode(2);
        ListNode n5 = new ListNode(5, n6);
        ListNode n4 = new ListNode(2, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(1, n2);
        Partition p = new Partition();
        ListNode ans = p.partition(n1, 3);
    }
}