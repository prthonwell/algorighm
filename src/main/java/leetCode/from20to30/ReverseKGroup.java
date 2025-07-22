package leetCode.from20to30;

import ob.ListNode;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    // 25 https://leetcode.cn/problems/reverse-nodes-in-k-group/
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode prev = hair;
        while (head != null) {
            ListNode tail = head;
            for (int i = 1; i < k; i++) {
                tail = tail.next;
                if (tail == null) return hair.next;
            }
            ListNode nex = tail.next;
            ListNode[] reversed = ReverseListNode(head, tail);
            head = reversed[0];
            tail = reversed[1];
            prev.next = head;
            tail.next = nex;
            prev = tail;
            head = nex;
        }
        return hair.next;
    }
    public static ListNode[] ReverseListNode(ListNode head, ListNode tail) {
        ListNode[] res = new ListNode[2];
        res[1] = head;
        ListNode next = head.next;
        while (head != tail) {
            ListNode temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }
        res[0] = tail;
        return res;


    }

    public static void main(String[] args) {
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(new ListNode(1));
        nodes.add(new ListNode(2));
        nodes.add(new ListNode(3));

        ListNode[] array = nodes.toArray(ListNode[]::new);


    }
}
