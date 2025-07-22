package ob;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ListNode {

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,
            5,
            1l,
            TimeUnit.MINUTES,
            new ArrayBlockingQueue<Runnable>(10));

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    public static ListNode CreateListNodeByNums(int[] nums) {
        ListNode cur = new ListNode(nums[0]);
        ListNode head = cur;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = CreateListNodeByNums(nums);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
