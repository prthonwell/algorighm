package from91to100;

class ReverseBetween {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        int index = 0;
        ListNode extra = new ListNode();
        extra.next = head;
        ListNode cur = extra;
        ListNode prev = null, Left = null, Right = null, Next = null;
        while (cur != null) {
            if (index == left - 1) {
                prev = cur;
                Left = cur.next;
            } else if (index == right) {
                Right = cur;
                Next = cur.next;
                break;
            }
            cur = cur.next;
            index++;
        }
        ListNode tail = Left;
        cur = Left.next;
        while (Left != Right) {
            ListNode tmp = cur.next;
            cur.next = Left;
            Left = cur;
            cur = tmp;
        }
        prev.next = Right;
        tail.next = Next;
        return extra.next;
    }
}